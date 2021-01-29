package br.com.abc.javacore.ZZDthreads.classe;

/**
 * MÉTODO yield()
 * Faz com que a thread que está executando no momento
 * volte para o estado Runnable, dando a chance para que outras com a mesma prioridade
 * possam continuar atuando
 * Infelizmente não tem garantias de que esse método vá funcionar
 */

public class ThreadYield {
    public static void main(String[] args) {
        Thread t0 = new Thread(new ThreadExemploPriorityRunnable("A"), "T0");
        Thread t1 = new Thread(new ThreadExemploPriorityRunnable("B"), "T1");
        Thread t2 = new Thread(new ThreadExemploPriorityRunnable("C"), "T2");
        Thread t3 = new Thread(new ThreadExemploPriorityRunnable("D"), "T3");

        t0.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }



}

class ThreadYieldRunnable implements Runnable {
    private String palavra;

    public ThreadYieldRunnable(String palavra) {
        this.palavra = palavra;
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + palavra);

        /***
         * Se a thread do momento for a T0...
         */
        if (Thread.currentThread().getName().equals("T0")){
            /***
             * ... dá um yield() nessa thread,
             * para a T1 brincar também
             */
            Thread.yield();
        }

        }
    }


}

