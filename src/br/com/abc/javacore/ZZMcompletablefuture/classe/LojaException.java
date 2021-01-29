package br.com.abc.javacore.ZZMcompletablefuture.classe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class LojaException {
    public String nome;

    public LojaException(String nome) {
        this.nome = nome;
    }

    public LojaException() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return calcularPreco();
    }

    /**
     * 2- Colocando um try-catch para completar a ação do CompletableFuture,
     * lançando uma ExecutionException
     */
    public Future<Double> getPrecoAsync() {
        CompletableFuture<Double> precoFuturo = new CompletableFuture<>();
        Thread thread1 = new Thread(() -> {
            try {
                precoFuturo.complete(calcularPreco());
            } catch (Exception e){
                precoFuturo.completeExceptionally(e);
            }
        });
        thread1.start();
        return precoFuturo;
    }

    private double calcularPreco() {
        delay();
        System.out.println(1/0);
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
