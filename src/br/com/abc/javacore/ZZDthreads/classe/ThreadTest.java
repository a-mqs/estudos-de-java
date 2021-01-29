package br.com.abc.javacore.ZZDthreads.classe;

/**
 * THREADS
 * Como se fossem trabalhadores que fazem os processos do
 * java, quanto mais threads, mais processos podem ser
 * feitos ao mesmo tempo
 * Aqui no java, as threads são instâncias (objetos) e também
 * linhas executáveis, algo como processos paralelos
 * Há 2 tipos de threads:
 * Daemon: threads que não influenciam no trabalho da JVM
 * (ex: garbage collector)
 * User: threads que, enquanto não terminarem, não encerrarão
 * a JVM
 */

public class ThreadTest {
    public static void main(String[] args) {
        /**
         * Threads criadas a partir de objetos de ThreadExemplo
         */
        ThreadExemplo t1 = new ThreadExemplo("A");
        ThreadExemplo t2 = new ThreadExemplo("V");
        ThreadExemplo t3 = new ThreadExemplo("J");
        ThreadExemplo t4 = new ThreadExemplo("S");

        /**
         * Threads criadas a pertir da classe Thread, que pede
         * por parâmetro um objeto Runnable
         */
        Thread t5 = new Thread(new ThreadExemploPriorityRunnable("A"));
        Thread t6 = new Thread(new ThreadExemploPriorityRunnable("B"));
        Thread t7 = new Thread(new ThreadExemploPriorityRunnable("C"));
        Thread t8 = new Thread(new ThreadExemploPriorityRunnable("D"));

        /**
         * Agora startamos as threads.
         */
        t1.run();
        t2.start();
        t3.run();
        t4.start();

        /**
         * Uma curiosidade: run() x start()
         *     Dentro de classes que extendem Threads
         *     e de classes que implementem Runnable, há o
         *     método run(). Veja esse método como um autódromo:
         *     você coloca seu código dentro dele (cria uma pista
         *     de corrida personalizada) e as threads (os corredores)
         *     o percorrem aleatóriamente.
         *
         *     O método main conta com uma única thread (chamada main tbm) percorrendo os
         *     códigos, isso para todos os códigos em Java. Então, ao chamar o run()
         *     direto, como em t1.run(), você está fazendo com que a
         *     thread main percorra o código dentro de run(), e como é apenas uma thread,
         *     ela só vai passar para t2 quando ela terminar.
         *
         *     Agora, quando você usa start(), a thread main "se reparte" em novas threads,
         *     como se fossem clones-filhos, para cada variável. Ou seja, t1 instancia a Thread-0, e assim
         *     por diante. Dessa forma, não será apenas um corredor na pista, e
         *     sim 4. Corredores que, ao serem acionados, decidem por conta própria
         *     quando correm pela pista ou quando param pra deixar algum outro correr.
         */
    }

}

/***
 * Uma thread pode ser criada tanto com uma classe
 * extendendo a classe thread
 */
class ThreadExemplo extends Thread{
    private String palavra;

    public ThreadExemplo(String palavra){
        this.palavra = palavra;
    }

    public void run(){
        for (int i = 0; i < 1000 ; i++) {
            System.out.print(palavra);
            if (i % 20 == 0){
                System.out.println("");
            }

        }
    }

}

/**
 * Quanto por uma classe implementando a interface Runnable
 */
class ThreadExemploRunnable implements Runnable {
    private String palavra;

    public ThreadExemploRunnable(String palavra){
        this.palavra = palavra;
    }

    /**
     * O método run é obrigatório da implementação
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + palavra);
            if (i % 20 == 0){
                System.out.println("");
            }

        }
    }
}


