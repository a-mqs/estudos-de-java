package br.com.abc.javacore.ZZMcompletablefuture.arrumandoacasa;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Arrumando {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Colocando o bolo pra assar
        Future<String> assandoBoloFuture = Tarefas.assandoBolo();

        // Varrendo a casa enquanto o bolo não ta pronto
        while (!assandoBoloFuture.isDone()) {
            Tarefas.varrerACasa();
        }

        System.out.println("Sentando pra descansar");

        // O bolo ficou pronto. Agora ja pode parar de varrer a casa
        // e pegar ele.
        Tarefas.delay(2);
        System.out.println(assandoBoloFuture.get());

        System.out.println("Comendo bolo");


    }
}
