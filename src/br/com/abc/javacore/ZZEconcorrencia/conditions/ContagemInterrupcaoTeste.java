package br.com.abc.javacore.ZZEconcorrencia.conditions;

public class ContagemInterrupcaoTeste {
    public static void main(String[] args) throws InterruptedException {
        ContagemInterrupcao contagemInterrupcao = new ContagemInterrupcao();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                contagemInterrupcao.contagem();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                contagemInterrupcao.interrupcao();
            }
        });

//        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}


