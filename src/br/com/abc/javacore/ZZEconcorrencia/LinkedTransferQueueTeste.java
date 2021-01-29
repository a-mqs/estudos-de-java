package br.com.abc.javacore.ZZEconcorrencia;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * CLASSE LinkedTransferQueue
 * Classe que reune o comportamento das classes ConcurrentLinkedQueue,
 * SynchronousQueue e LinkedBlockingQueue. É mais recomendado usar, de acordo
 * com a Katy Sierra
 */

public class LinkedTransferQueueTeste {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue tq = new LinkedTransferQueue();
        /**
         * Formas de adicionar valores
         */
        // add(): retorna um boolean true se o valor nos parenteses for adicionado.
        // Caso não haja valor nos parentes, será retornada uma IllegalStateException
        System.out.println(tq.add("Jungkook"));

        // put(): adiciona um item e bloqueia a thread se a capacidade tiver estourada
        tq.put("Devdojo");

        // offer(): retorna true se o item for adicionado ou false se o limite
        // estiver estourado, recomendado no lugar do add
        System.out.println(tq.offer("Jungkook"));

        // offer() sobrecarregado: retorna true se um item foi adicionado
        // dentro de algum espaço de tempo e false se a lista já estiver cheia
        System.out.println(tq.offer("Jungkook", 10, TimeUnit.SECONDS));

        // transfer(): bloqueia a operação até que esse elemento seja consumido por
        // outra thread
        tq.transfer("Devdojo");

        // tryTransfer(): vai retornar true se for consumido por uma thread que ta
        // esperando, se não tiver thread esperando, vai retornar false
        System.out.println(tq.tryTransfer("Devdojo"));

        // tryTransfer() sobrecarregado: funciona da mesma forma que o offer sobrecarregado, mas
        // esse espera um determinado tempo para ser consumido
        System.out.println(tq.tryTransfer("Devdojo", 10, TimeUnit.SECONDS));

        // capacidade do TransferQueue
        System.out.println(tq.remainingCapacity());

        /**
         * Formas de pegar valores
         */
        // element(): pega o primeiro valor sem remover,
        // lança a NoSuchElementException se a queue estiver vazia
        System.out.println(tq.element());

        // peek(): pega o primeiro valor sem remover e retonar null
        // se for vazio
        System.out.println(tq.peek());

        // poll(): pega o primeiro valor e o remove da lista
        System.out.println(tq.poll());

        // poll() sobrecarregado: remove o primeiro valor e espera
        // esse tempo antes de retornar null se estiver vazio
        System.out.println(tq.poll(10, TimeUnit.MILLISECONDS));

        // remove(): remove o primeiro valor, lança a NoSuchElementException
        // se a queue estiver vazia
        System.out.println(tq.remove());

        // take(): vai remover o primeiro valor ou "bloquear" o
        // programa até alguma thread removê-lo
        System.out.println(tq.take());
    }


}
