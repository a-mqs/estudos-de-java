package br.com.abc.javacore.ZZDthreads.teste;


/**
 * DEADLOCK:
 * Usando o exemplo dos corredores, imagine que 2 corredores(threads)
 * precisam passar por duas caverninhas(métodos) conectadas.
 * Para que um corredor possa sair da sua caverninha e entrar na outra,
 * ele precisa da chave dela, que ta em posse do outro corredor.
 * Mas o outro também não pode continuar e entrar, porque tá esperando a
 * chave do primeiro. E o melhor de tudo:
 * ELES SÃO BURROS!!
 * Eles não voltam, não fazem nada
 * Só ficam ali parados
 * E são eles ficarem parados que é o Deadlock,
 * acabou ali, morreu o código, eles estão empacados.
 *
 * Obs: para que o código flua, no run de alguma classe,
 * lock1 deve ser trocado de lugar com lock2
 */

public class DeadlockTeste {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadlockExemplo1 dlEx1 = new DeadlockExemplo1();
        DeadlockExemplo2 dlEx2 = new DeadlockExemplo2();

        dlEx1.start();
        dlEx2.start();

    }

    private static class DeadlockExemplo1 extends Thread{
        @Override
        public void run() {
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() + ": Segurando o lock1");
                System.out.println(Thread.currentThread().getName() + ": Esperando pelo lock2");
                /**
                 * sleep() aleatório aqui pra simular um processamento
                 */
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName() + ": Segurando o lock2");
                }
            }
        }
    }

    private static class DeadlockExemplo2 extends Thread{
        @Override
        public void run(){
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + ": Segurando o lock2");
                System.out.println(Thread.currentThread().getName() + ": Esperando pelo lock1");
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName() + ": Segurando o lock1");
                }
            }
        }
    }

}


