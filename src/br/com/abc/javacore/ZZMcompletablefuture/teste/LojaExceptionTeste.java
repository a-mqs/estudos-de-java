package br.com.abc.javacore.ZZMcompletablefuture.teste;

import br.com.abc.javacore.ZZMcompletablefuture.classe.LojaException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * EXCEPTIONS AO LIDAR COM FUTURES
 * Caso um método Future lance uma exceção, sua resposta
 * nunca poderá ser obtida através do get() e o método não
 * será finalizado. Existem duas formas de lidar com isso:
 */

public class LojaExceptionTeste {
    public static void main(String[] args) {
        LojaException americanas = new LojaException();
        LojaException casasBahia = new LojaException();
        LojaException bestBuy = new LojaException();
        LojaException wallmart = new LojaException();

        System.out.println("Preços exibidos de forma assíncrona");

        long startAsync = System.currentTimeMillis();
        Future<Double> precoAsyncAmericanas = americanas.getPrecoAsync();
        Future<Double> precoAsyncCasasBahia = casasBahia.getPrecoAsync();
        Future<Double> precoAsyncBestBuy = bestBuy.getPrecoAsync();
        Future<Double> precoAsyncWallmart = wallmart.getPrecoAsync();

        long endAsyncInvocacao = System.currentTimeMillis();

        System.out.println("Tempo de invocação dos preços: " + (endAsyncInvocacao - startAsync) + " ms");

        enrolandoComSoma();

        try {
            /**
             * 1- Definir um tempo máximo de espera de execução, uma boa prática
             */
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
