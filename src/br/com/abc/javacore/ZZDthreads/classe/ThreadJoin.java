package br.com.abc.javacore.ZZDthreads.classe;

/**
 * MÉTODO join()
 * Esse método não é estático, ou seja, ele deve ser adicionado
 * sobre um objeto thread.
 * Funciona como o start(), mas de uma forma um pouco diferente:
 * É como se disséssemos: "main, só execute as linhas que vierem depois
 * de t1 quando sua thread já tiver executado tudo que precisa"
 * Lança a exceção InterruptedException
 */


public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new ThreadExemploJoinRunnable("A"));
        Thread t1 = new Thread(new ThreadExemploJoinRunnable("B"));
        Thread t2 = new Thread(new ThreadExemploJoinRunnable("B"));
        Thread t3 = new Thread(new ThreadExemploJoinRunnable("B"));

        t0.start();
        t0.join();
        t1.start();
        t2.start();
        t3.start();


    }
}

class ThreadExemploJoinRunnable implements Runnable {
    private String palavra;

    public ThreadExemploJoinRunnable(String palavra) {
        this.palavra = palavra;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + palavra);
            if (i % 20 == 0) {
                System.out.println("");
            }

        }
    }
}


