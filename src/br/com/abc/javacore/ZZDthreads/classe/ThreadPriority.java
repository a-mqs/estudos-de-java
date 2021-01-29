package br.com.abc.javacore.ZZDthreads.classe;

/**
 * PRIORIDADE NAS THREADS
 * Isso só funciona na teroria, na prática não é garantido.
 */

public class ThreadPriority {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new ThreadExemploPriorityRunnable("A"));
        Thread t1 = new Thread(new ThreadExemploPriorityRunnable("B"));
        Thread t2 = new Thread(new ThreadExemploPriorityRunnable("C"));
        Thread t3 = new Thread(new ThreadExemploPriorityRunnable("D"));

        t0.setPriority(Thread.MAX_PRIORITY);

        t0.start();
        t1.start();
        t2.start();
        t3.start();


    }


}

class ThreadExemploPriorityRunnable implements Runnable {
    private String palavra;

    public ThreadExemploPriorityRunnable(String palavra){
        this.palavra = palavra;
    }

    /**
     * O método run é obrigatório da implementação
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            System.out.println("[" + i + "] " + Thread.currentThread().getName() + ": " + palavra + " ");


        }
    }

}

