package br.com.abc.javacore.ZZMcompletablefuture.classe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * supplyAsync()
 * Uma forma mais simples de se escrver métodos com CompletableFuture
 */

public class LojaSA {
    public String nome;

    public LojaSA(String nome) {
        this.nome = nome;
    }

    public LojaSA() {
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

    /**
     * Usando o supplyAsync, você tem uma repetição do método anterior
     * inteiro, desde a criação de uma thread paralela, a invocação do
     * complete em algum método já pronto (calcularPreco(), nesse caso)
     * e proteção para possíveis exceções
     */
    public Future<Double> getPrecoAsyncTunado() {
        return CompletableFuture.supplyAsync(this::calcularPreco);
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
