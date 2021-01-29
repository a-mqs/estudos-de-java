package br.com.abc.javacore.ZZDthreads.ProdutorConsumidor;

public class ProcessadorTeste {
    public static void main(String[] args) throws InterruptedException {
        final Processador processador = new Processador();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    processador.produtor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    processador.produtor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    processador.produtor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t4 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    processador.consumidor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t5 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    processador.consumidor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t6 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    processador.consumidor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
        t5.start();
        t6.start();


    }
}
