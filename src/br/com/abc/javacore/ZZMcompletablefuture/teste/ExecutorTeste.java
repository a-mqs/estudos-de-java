package br.com.abc.javacore.ZZMcompletablefuture.teste;

import java.util.concurrent.*;

/***
 * FUTURE
 * O resultado que demora a ser processado graças a um delay e é
 * retornado após estar completo.
 * O future associado a alguma dessas tarefas fará com que seu retorno
 * seja exibido após o processamento do outro estar completo.
 */

public class ExecutorTeste {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        Future<Double> future = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(4);
            return 2000D;
        });

        enrolandoComSoma();
        enrolandoEscrevendo();

        Double resultado = null;
        try {
            // Enquanto o enrolandoComSoma e o enrolandoEscrevendo rolam,
            // o get() no future define um tempo para exibir aquela resposta.
            // Obviamente o tempo do get tem que ser maior, para aparecer o resultado depois que o call do
            // future estiver completo, senão será lançada uma exceção
            resultado = future.get(12, TimeUnit.SECONDS);
        // O get() lança essas 3 exceções
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // e é necessário puxar o shutdown para ele, senão ele não para
            executorService.shutdown();
        }

        System.out.println(resultado);

    }

    private static void enrolandoComSoma() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }
        System.out.println(soma);
    }

    private static void enrolandoEscrevendo() {
        System.out.println("Escrevendo... ");
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Escrito!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


