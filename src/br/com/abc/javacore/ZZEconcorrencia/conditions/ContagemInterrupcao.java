package br.com.abc.javacore.ZZEconcorrencia.conditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition: wait(), notify() e notifyAll() NO ALTO NIVEL
 * <p>
 * Se você estiver trabalhando com ReentrantLock,
 * você não vai poder usar wait() e notifyAll()
 * da maneira que está habituado. Dessa forma,
 * você vai ter que usar a classe Condition para
 * lidar com os locks dos objetos ReentrantLock.
 * Condition deve acompanhar o ReentrantLock, ou
 * seja, não é cabível se você estiver trabalhando
 * em um contexto sincronizado (o que é bem mais
 * recomendado na maioria dos casos).
 */

public class ContagemInterrupcao {
    final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition conditionLock = reentrantLock.newCondition();

    public void contagem() {
        try {
            reentrantLock.lock();

            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    /**
                     * Colocar lock() e unlock() dentro do
                     * try-catch normalmente, mas puxar
                     * o método Conditional.await() para
                     * wait()
                     */
                    conditionLock.await();
                    i++;
                    System.out.println(i);

                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();

        }

    }

    public void interrupcao() {
        try {
            reentrantLock.lock();
            Thread.sleep(2000);
            System.out.println("Ué, já deu os 5?");
            Thread.sleep(500);
            System.out.println(".");
            Thread.sleep(500);
            System.out.println("..");
            Thread.sleep(500);
            System.out.println("...");
            Thread.sleep(500);
            System.out.println("Okay, já pode voltar pra lá");
            /**
             * O mesmo aqui: para notifyAll(), é puxado
             * o Conditions.signalAll()
             */
            conditionLock.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

}

