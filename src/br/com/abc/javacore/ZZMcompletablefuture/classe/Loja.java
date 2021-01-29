package br.com.abc.javacore.ZZMcompletablefuture.classe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {
    public String nome;

    public Loja(String nome) {
        this.nome = nome;
    }

    public Loja() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco(){
        // pega o preço dos produtos
        return calcularPreco();
    }

    public Future<Double> getPrecoAsync(){
        CompletableFuture<Double> precoFuturo = new CompletableFuture<>();
        Thread thread1 = new Thread(() -> {
            // É uma boa prática precaver métodos envolnvendo threads com exceptions...
            try {
                precoFuturo.complete(calcularPreco());
            } catch (Exception e) {
                precoFuturo.completeExceptionally(e);
            }
        });
        thread1.start();
        return precoFuturo;
    }

    private double calcularPreco(){
        delay();
        // Esse é tipo o método Math.random(), mas adaptado pra threads
        // e multiplicado por 100, pq o resultado aparece entre 0 e 1
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
