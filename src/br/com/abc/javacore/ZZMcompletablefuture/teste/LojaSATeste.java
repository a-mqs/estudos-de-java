package br.com.abc.javacore.ZZMcompletablefuture.teste;

import br.com.abc.javacore.ZZMcompletablefuture.classe.LojaSA;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LojaSATeste {
    public static void main(String[] args) {
        LojaSA americanas = new LojaSA();
        LojaSA casasBahia = new LojaSA();
        LojaSA bestBuy = new LojaSA();
        LojaSA wallmart = new LojaSA();

        System.out.println("Preços exibidos de forma assíncrona");

        long startAsync = System.currentTimeMillis();

        Future<Double> precoAsyncAmericanas = americanas.getPrecoAsyncTunado();
        Future<Double> precoAsyncCasasBahia = casasBahia.getPrecoAsyncTunado();
        Future<Double> precoAsyncBestBuy = bestBuy.getPrecoAsyncTunado();
        Future<Double> precoAsyncWallmart = wallmart.getPrecoAsyncTunado();

        long endAsyncInvocacao = System.currentTimeMillis();

        System.out.println("Tempo de invocação dos preços: " + (endAsyncInvocacao - startAsync) + " ms");

        enrolandoComSoma();

        try {

            System.out.println("Americanas: " + precoAsyncAmericanas.get(3, TimeUnit.SECONDS));
            System.out.println("CasasBahia: " + precoAsyncCasasBahia.get(3, TimeUnit.SECONDS));
            System.out.println("BestBuy: " + precoAsyncBestBuy.get(3, TimeUnit.SECONDS));
            System.out.println("Wallmart: " + precoAsyncWallmart.get(3, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        long endAsyncExibicao = System.currentTimeMillis();

        System.out.println("Tempo de invocacao e exibição dos precos: " + (endAsyncExibicao - startAsync) + " ms");

    }

    private static void enrolandoComSoma() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(soma);
    }
}
