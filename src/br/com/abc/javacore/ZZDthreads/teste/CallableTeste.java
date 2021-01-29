package br.com.abc.javacore.ZZDthreads.teste;

import java.util.concurrent.*;

public class CallableTeste implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTeste callable = new CallableTeste();
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> resultFuture = executorService.submit(callable);

        String stringResult = resultFuture.get();
        System.out.println(stringResult);
        executorService.shutdown();

    }




    @Override
    public String call() throws Exception {
        int contador = ThreadLocalRandom.current().nextInt(1, 10);
        for (int i = 0; i < contador; i++) {
            System.out.println(Thread.currentThread().getName() + "executando...");

        }

        return "Trabalho finalizado. O numero aleatorio é: " + contador;
    }
}
