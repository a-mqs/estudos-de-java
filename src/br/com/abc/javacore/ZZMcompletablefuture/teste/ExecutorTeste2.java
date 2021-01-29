package br.com.abc.javacore.ZZMcompletablefuture.teste;

import br.com.abc.javacore.ZZMcompletablefuture.classe.Loja;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * CUSTOMIZAÇÃO DE EXECUTOR
 * Quando você quer fazer com que threads acelerem seus processos.
 * O número de threads que serão usadas num contexto é baseado na formula:
 * nThreads = nCpu * uCpu * (1 + W/C), onde
 *      nCpu = numero de cores disponiveis
 *      uCpu = quantidade de utilização do cpu (entre 0-1, simbolizando 0-100%)
 *      W = wait time
 *      C = compute time
 */

public class ExecutorTeste2 {
    public static void main(String[] args) {
        List<Loja> lojas = asList(
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("wallmart"),
                new Loja("bestbuy")
        );

        acharPrecosStreamParalelo(lojas);
        System.out.println("-----------------------------------------");
        acharPrecosCompletableFutureAssincrono(lojas);


        // Parâmetros do newFixedThreadPool():
        // nThreads, que nesse caso o mínimo é o numero de itens
        // da lista lojas e o máximo são 100
        // threadFactory, que pode definir a criação de uma thread de forma diferente do padrão
        final Executor executorArg = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
            Thread t = new Thread(r);
            // A difereça de threads com setDaemon é que elas serão finalizadas junto com
            // o processo se ele for finalizado, ao invés de serem executadas até o fim
            // como normalmente acontece
            t.setDaemon(true);
            return t;
        });

        System.out.println("-----------------------------------------");
        acharPrecosCompletableFutureAsyncExecutor(lojas, executorArg);


    }

    private static List<String> acharPrecosStreamParalelo (List<Loja> lojas){
        System.out.println("Stream paralelo");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.parallelStream()
                .map(loja -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Tempo de execução do acharPrecos(): " + (end - start) + " ms");
        System.out.println(collect);
        return collect;

    }

    private static List<String> acharPrecosCompletableFutureAssincrono (List<Loja> lojas){
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> precoFuturoCollect = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco())
                ))
                .collect(Collectors.toList());
        long endCF = System.currentTimeMillis();
        System.out.println("Tempo para o retorno da lista de CompletableFuture: " + (endCF - start) + " ms");

        List<String> collect = precoFuturoCollect.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        long endProcesso = System.currentTimeMillis();
        System.out.println("Tempo para execução total do método:" + (endCF - start) + " ms");

        System.out.println(collect);
        return collect;

    }

    private static List<String> acharPrecosCompletableFutureAsyncExecutor (List<Loja> lojas, Executor executor){
        System.out.println("Completable Future com executor personalizado");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> precoFuturoCollect = lojas.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco(), executor)
                ))
                .collect(Collectors.toList());
        long endCF = System.currentTimeMillis();
        System.out.println("Tempo para o retorno da lista de CompletableFuture: " + (endCF - start) + " ms");

        List<String> collect = precoFuturoCollect.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        long endProcesso = System.currentTimeMillis();
        System.out.println("Tempo para execução total do método:" + (endProcesso - start) + " ms");

        System.out.println(collect);
        return collect;

    }

}
