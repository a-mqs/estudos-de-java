package br.com.abc.javacore.ZZDthreads.teste;

import br.com.abc.javacore.ZZDthreads.classe.Conta;

/**
 * SYNCHRONIZED:
 * Métodos ou blocos de código sincronizados funcionam
 * deixando com que apenas uma thread os acessem por vez até
 * ela terminar o que está fazendo. Em métodos se utiliza
 * a palavra reservada synchronized e em blocos precisa
 * ser dada uma chave a thread que a só ela tenha acesso
 * (chaves, ou locks, podem ser quaisquer objetos)
 */


public class ContaTeste implements Runnable {
    private Conta conta = new Conta();

    public static void main(String[] args) {
        ContaTeste contaTeste = new ContaTeste();
        Thread amanda = new Thread(contaTeste, "Amanda");
        Thread jungkook = new Thread(contaTeste, "Jungkook");

        amanda.start();
        jungkook.start();

    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            saqueSynchMeth(10);
            if (conta.getSaldo() < 0) {
                System.out.println("Há um número negativo aqui, isso não devia acontecer!");
            }
        }
    }

    /**
     * SINCRONISMO EM MÉTODO.
     * Se o método for estático, o lock
     * vai proteger a classe inteira (torná-la Thread Safe)
     * de onde ele vem, já que ele é pertencente a classe.
     */
    private synchronized void saqueSynchMeth(int valor) {
        if (conta.getSaldo() >= valor) {
            System.out.println(Thread.currentThread().getName() + " está indo sacar");
            conta.saque(valor);
            System.out.println(Thread.currentThread().getName() + " completou o saque. Saldo: " + conta.getSaldo());
        } else {
            System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque. Saldo: " + conta.getSaldo());
        }
    }

    /**
     * SINCRONISMO EM BLOCO
     * Observe o lock da classe object e como ele pode
     * ser usado como chave de acesso
     * Também é possivel sincronizar uma classe em bloco,
     * assim como num método estatico, colocando a classe
     * em questão na forma literal (Classe.class, vide comentario)
     */
    private void saqueSynchBlock(int valor) {
//        synchronized(ContaTeste.class){
        synchronized (conta){
            if (conta.getSaldo() >= valor) {
                System.out.println(Thread.currentThread().getName() + " está indo sacar");
                conta.saque(valor);
                System.out.println(Thread.currentThread().getName() + " completou o saque. Saldo: " + conta.getSaldo());
            } else {
                System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque. Saldo: " + conta.getSaldo());
            }
        }

    }



}