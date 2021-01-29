package br.com.abc.javacore.ZZMcompletablefuture.teste;

import br.com.abc.javacore.ZZMcompletablefuture.classe.Loja;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * COMPARAÇÃO DE DESEMPENHO
 * Streams sequenciais x streams paralelas x CompletableFuture
 */
public class LojaTeste2 {
    public static void main(String[] args) {
        List<Loja> lojas = asList(
            new Loja("americanas"),
            new Loja("casas bahia"),
            new Loja("wallmart"),
            new Loja("bestbuy")
        );

        acharPrecosStreamSequencial(lojas);
        System.out.println("-----------------------------------------");
        acharPrecosStreamParalelo(lojas);
        System.out.println("-----------------------------------------");
        acharPrecosCompletableFutureSequencial(lojas);
        System.out.println("-----------------------------------------");
        acharPrecosCompletableFutureAssincrono(lojas);

        // Streams paralelos e CompletableFutures assíncronos
        // apresentam resultados parecidos quanto ao processamento
        // por terem o mesmo pool de threads,
        // mas o CompletableFuture pode ter um Executor personalizado,
        // o que garante a ele vantagem



        // Uma palinha sobre String.format()
        System.out.println("-----------------------------------------");
        Loja lojaFormat = new Loja("Extra");
        String format = String.format("O nome da loja é %s", lojaFormat.getNome());
        System.out.println(format);

    }

    // Usando Streams Sequenciais
    private static List<String> acharPrecosStreamSequencial (List<Loja> lojas){
        System.out.println("Stream sequencial");
        long start = System.currentTimeMillis();
        List<String> collect = lojas.stream()
                .map(loja -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Tempo de execução do acharPrecos(): " + (end - start) + " ms");
        System.out.println(collect);
        return collect;

    }

    // Usando Streams com threads trabalhando paralelamente
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

    // Usando CompletableFuture, mas sequencial
    private static List<String> acharPrecosCompletableFutureSequencial (List<Loja> lojas){
        System.out.println("Completable Future");
        long start = System.currentTimeMillis();

        final List<String> collect = lojas.stream()
                // Aqui o método atribuído à stream é o
                // retorno de uma String.format(), mas encapsulado com um supplyAsync()
                // pra tratar das exceções...
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preço é: %.2f", loja.getNome(), loja.getPreco())
                ))
                // E como isso vai gerar como retorno um CompletableFuture<String>,
                // vai ser necessário usar ou o get() ou o join(), um get() sem exceções
                // do CompletableFuture pra gerar o valor daquilo
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo de execução do acharPrecos(): " + (end - start) + " ms");
        System.out.println(collect);
        return collect;

    }

    // Usando CompletableFuture, assincrono
    private static List<String> acharPrecosCompletableFutureAssincrono (List<Loja> lojas){
        // A forma do CompletableFuture apresentada anteriormente, por estar numa stream,
        // é trabalhada de uma forma lazy pelos métodos intermediate. Ou seja, é como se
        // estivessemos lidando com CompletableFutures sequenciais. Para contornar isso,
        // é necessário quebrar essa stream em duas (primeiro a invocação, depois a execução).
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
        System.out.println("Tempo para execução total do método:" + (endProcesso  - start) + " ms");

        System.out.println(collect);
        return collect;

    }

}
