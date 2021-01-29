package br.com.abc.javacore.ZZMcompletablefuture.arrumandoacasa;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Tarefas {

    // Varrer a casa é uma tarefa simples, que você mesmo pode executar
    // sem dependencia de espera
    public static void varrerACasa() {
        System.out.println("Varrendo a casa");
        delay(1);

    }

    // Já assar um bolo é o tipo de tarefa que você tem que esperar pra
    // ficar pronta, por isso ela é do tipo Future
    public static Future<String> assandoBolo() {
        CompletableFuture<String> boloAssado = new CompletableFuture<>();
        new Thread(() -> {
            System.out.println("Colocando bolo no forno");
            delay(10);
            boloAssado.complete("O bolo foi assado");
        }).start();
        return boloAssado;
    }

    public static void delay(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
