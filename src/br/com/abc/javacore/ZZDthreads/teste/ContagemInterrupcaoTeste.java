package br.com.abc.javacore.ZZDthreads.teste;

import br.com.abc.javacore.ZZDthreads.classe.ContagemInterrupcao;

public class ContagemInterrupcaoTeste {
    public static void main(String[] args) throws InterruptedException {
        ContagemInterrupcao contagemInterrupcao = new ContagemInterrupcao();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    contagemInterrupcao.contagem();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    contagemInterrupcao.interrupcao();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
