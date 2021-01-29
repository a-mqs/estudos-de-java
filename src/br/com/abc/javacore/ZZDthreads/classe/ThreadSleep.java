package br.com.abc.javacore.ZZDthreads.classe;

/***
 * MÉTODO sleep()
 * Esse método serve para fazer a thread que passar por ele
 * dormir, parar de fazer os comandos pelo tempo que o desenvolvedor
 * desejar
 */

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new ThreadExemploSleepRunnable("A"), "T0");
        Thread t1 = new Thread(new ThreadExemploSleepRunnable("B"), "T1");

        t0.start();
        t1.start();

    }

}

class ThreadExemploSleepRunnable implements Runnable {
    private String palavra;

    public ThreadExemploSleepRunnable(String palavra) {
        this.palavra = palavra;
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + palavra);

            /**
             * Método sleep(), lançando a exceção InterruptedException
             * Durante os testes, o método fazia com que as threads parassem
             * para dormir ao mesmo tempo, mas esse é um código pequeno,
             * então isso não é garantido.
             */

            if (Thread.currentThread().getName().equals("T1")){
                try {
                    Thread.sleep(5000);
                    System.out.println("Passaram os 5 segundos");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }




        }
    }


}