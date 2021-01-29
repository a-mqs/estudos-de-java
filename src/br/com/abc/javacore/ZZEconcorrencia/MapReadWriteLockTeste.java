package br.com.abc.javacore.ZZEconcorrencia;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * INTERFACE ReadWriteLock
 *
 * Interface que manipula locks no âmbito de leitura e escrita.
 * Quando um dado está sendo escrito, alterado, não é bom permitir
 * que mais de uma thread cuide das alterações porque isso traz
 * resultados indesejados. Já vimos isso acontecer.
 * Agora, quando um dado está sendo lido, não tem problema que
 * várias threads auxiliem o processo de leitura.
 *
 * Essa interface ajuda justamente nisso: ela tem locks próprios
 * para escrita, que funciona como locks comuns, e de leitura,
 * o qual várias threads podem obter. Pode não parecer, mas
 * os locks de leitura são importantes e devem sim ser colocados
 * ao se usar os de escrita, porque geram exceções se não incluídos.
 *
 * A classe que a implementa é o ReentrantReadLock (É tipo Thread
 * implementando Runnable)
 *
 */

class MapReadWrite{
    private Map<String, String> map = new LinkedHashMap<>();

    public void put (String key, String value){
        map.put(key, value);
    }

    public Object[] allKeys(){
        return map.keySet().toArray();
    }
}

public class MapReadWriteLockTeste {
    private static final MapReadWrite mapReadWrite = new MapReadWrite();
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        /**
         * Essa é a thread que vai colocar os valores
         * gerados pelo for dentro do map
         */
        Thread t0 = new Thread(new Write());
        /**
         * Essas duas threads lerão o resultado
         */
        Thread t1 = new Thread(new ReadA());
        Thread t2 = new Thread(new ReadB());

        t0.start();
//        t0.join();
        t1.start();
        t2.start();

    }

    static class Write implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                /**
                 * A variável de ReadWriteLock adaptada
                 * para seu modo de escrita (writeLock())
                 * e usando de sua modificação em objeto
                 * para ceder o lock
                 */
                readWriteLock.writeLock().lock();
                try {
                    mapReadWrite.put(String.valueOf(i), String.valueOf(i));
                } finally {
                    /**
                     * unlock() dentro de um finnaly,
                     * mesmo que não tenha um catch.
                     */
                    readWriteLock.writeLock().unlock();

                }
            }
        }
    }

    static class ReadA implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                /**
                 * Agora a mesma variável adaptada para
                 * readLock()
                 */
                readWriteLock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " " + Arrays.toString(mapReadWrite.allKeys()));
                } finally {

                    readWriteLock.readLock().unlock();

                }
            }
        }
    }

    static class ReadB implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                readWriteLock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " " + Arrays.toString(mapReadWrite.allKeys()));
                } finally {

                    readWriteLock.readLock().unlock();

                }
            }
        }
    }


}


