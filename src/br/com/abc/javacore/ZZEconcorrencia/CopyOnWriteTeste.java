package br.com.abc.javacore.ZZEconcorrencia;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * COLLECTIONS SEMITHREADSAFES
 * A classe CopyOnWriteTest é uma classe que cria objetos finais,
 * ou seja, objetos que ao serem criados não há como mudar seus
 * valores de parâmetros (só se você tiver acesso ao construtor
 * do objeto).
 *
 * Sendo uma classe final, ela notoriamente é ThreadSafe, porque
 * um dos prejuízos da concorrência é justamente a alteração
 * indevida de dados. E não da pra alterar objetos finais.
 *
 * Contudo, ela é semi ThreadSafe porque AS LISTAS são finais,
 * já os objetos dentro delas nem sempre.
 *
 * Uma forma de se fazer alteração (bem gambiarra do Java) é na hora
 * de dar add() ou remove(), o Java excluir a primeira lista e criar
 * por si uma nova adicionando ou retirando os valores. As boas práticas
 * dizem pra usar essa classe para leitura, por conseguinte.
 */

public class CopyOnWriteTeste implements Runnable{
    public static void main(String[] args) {
        CopyOnWriteTeste ct = new CopyOnWriteTeste();
        Thread t1 = new Thread(ct, "Thread-1");
        Thread t2 = new Thread(ct, "Thread-2");
        Thread removedor = new Thread(new RemovedorMembros(ct.getList()), "Thread-removedor");

        t1.start();
        t2.start();
        removedor.start();

    }

    private List<Integer> list = new CopyOnWriteArrayList<>();

    public CopyOnWriteTeste() {
        for (int i = 0; i <= 9000; i++) {
            list.add(i);
        }
    }

    @Override
    public void run() {
        // O iterator vai exibir a lista do momento em que
        // ele pegou, por isso vai aparecer a lista mesmo
        // depois dela ser removida
        Iterator<Integer> iterator = list.iterator();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (iterator.hasNext()){
            System.out.println(Thread.currentThread().getName() + " " + iterator.next());

        }
    }

    public List<Integer> getList(){
        return list;
    }

    private static class RemovedorMembros implements Runnable{
        private List<Integer> list;

        public RemovedorMembros(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 500; i++) {
                System.out.println(Thread.currentThread().getName() + " removeu: " + list.remove(i));
            }
        }
    }
}














