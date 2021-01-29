package br.com.abc.javacore.ZZMcompletablefuture.teste;

import br.com.abc.javacore.ZZMcompletablefuture.classe.Desconto;
import br.com.abc.javacore.ZZMcompletablefuture.classe.NovaLoja;
import br.com.abc.javacore.ZZMcompletablefuture.classe.Orcamento;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Sistema um pouco mais real feito para mostrar uma aplicação,
 * do CompletableFuture na vida real.
 * Aqui lidamos com um sistema de desconto em lojas, que calcula o orçamento
 * para obter o preço final com desconto.
 */

public class NovaLojaTeste {
    public static void main(String[] args) {
        /**
         * FORMA SÍNCRONA
         */
        List<NovaLoja> lojas = NovaLoja.lojas();
//        lojas.stream().forEach(novaLoja -> System.out.println(novaLoja.getPreco()));
//        acharPrecos(lojas);

        final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100),
            r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        /**
         * FORMA ASSÍNCRONA
         */
        acharPrecosAsync(lojas, executor);

        /**
         * FORMA ASSÍNCRONA E EM TEMPO REAL
         */
        long start = System.currentTimeMillis();

        // Aqui é a requisição
        CompletableFuture[] completableFutures = acharPrecosStream(lojas, executor)
                // thenAccept(): executa algum comando ao obter o resultado do CompletableFuture
                // Um variante desse método é o thenAcceptAsync(), que faz a mesma coisa, mas executando
                // em uma nova thread.
                .map(future -> future.thenAccept(s -> System.out.println(s + " (finalizado em "
                        // Isso é pra marcar o tempo em que cada loja foi finalizada
                        + (System.currentTimeMillis() - start) + " ms)")))
                // Mas esse map não vai fazer nada, porque precisamos dar um
                // join() em cada um desses resultados. Para isso, primeiro,
                // criamos um array e colocamos essa Stream la dentro.
                .toArray(CompletableFuture[]::new);

        // Conforme os CompletableFutures forem sendo completados, o método
        // allOf() vai colocando eles num novo CompletableFuture. Caso alguma das requisições
        // termine lançando uma exceção, ele vai terminar excepcionalmente o método.
        CompletableFuture.allOf(completableFutures)
                // E a cada CompletableFuture adicionado no novo, é usado nele
                // um join(), o que faz o valor ser exibido instantaneamente.
                .join();
        System.out.println("Todas as lojas responderam em: " + (System.currentTimeMillis() - start) + " ms");

        // Análogo ao allOf(), também existe o anyOf(), que vai finalizar quando apenas um dos resultados
        // for obtido.
        // Além disso, há também o thenCombine(), usado quando você precisa usar o thenCompose()
        // ao querer pegar parâmetros de 2 CompletableFutures diferentes, por exemplo.



    }

    private static List<String> acharPrecos(List<NovaLoja> lojas) {
        System.out.println("Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream().map(NovaLoja::getPreco)
                .map(Orcamento::parse)
                .map(Desconto.Codigo::calcularPreco)
                .collect(Collectors.toList());
        System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    private static List<String> acharPrecosAsync(List<NovaLoja> lojas, Executor executor) {
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> completableFutures = lojas.stream()
                // Pegando o preço original de forma Async
                .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
                // thenApply(): método que te permite fazer algo com os resultados obtidos do future. É
                // um método usado com map() que lida com operações síncronas.
                // Nesse caso, transforma a string em um Orcamento no momento em que ele se torna disponivel
                .map(future -> future.thenApply(Orcamento::parse))
                // thenCompose(): mesmo que o thenApply(), mas apropriado para operações assíncronas.
                // Aqui, compõe o primeiro future com mais uma chamada async, para pegar os descontos no
                // momento em que a primeira requisição async estiver disponível
                .map(future -> future.thenCompose(orcamento ->
                        CompletableFuture.supplyAsync(() -> Desconto.Codigo.calcularPreco(orcamento), executor)))
                .collect(Collectors.toList());

        // E separadamente, numa outra stream, requisitamos os futures já finalizados para extrair os
        // resultados deles
        List<String> collect = completableFutures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
        System.out.println(collect);
        return collect;
    }

    /**
     * Contudo, até agora estamos requisitando todos os resultados e, só após ter todos,
     * exibindo-os. Isso não é programação assíncrona, e para ser, as respostas precisam ser dadas
     * em tempo real, assim que forem obtidas.
     */

    // Esse método, então, vai retornar um Stream de CompletableFuture<String>, que fará a requsição quando
    // for chamado no main e lá mesmo deve-se obter os valores, não mais no método.
    private static Stream<CompletableFuture<String>> acharPrecosStream(List<NovaLoja> lojas, Executor executor) {
        System.out.println("Completable Future Async Stream");
        Stream<CompletableFuture<String>> completableFutureStream = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
                .map(future -> future.thenApply(Orcamento::parse))
                .map(future -> future.thenCompose(orcamento -> CompletableFuture.supplyAsync(
                        () -> Desconto.Codigo.calcularPreco(orcamento), executor)));


        return completableFutureStream;
    }

}
