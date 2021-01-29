package br.com.abc.javacore.ZZDthreads.ProdutorConsumidor;

import java.util.Scanner;

class Processador {
    public void produtor() throws InterruptedException {
        synchronized (this){
            System.out.println("================= " +  Thread.currentThread().getName() + ": Dentro do Produtor =================");
            System.out.println(Thread.currentThread().getName() + ": Thread produtora correndo...");
            wait();
            System.out.println(Thread.currentThread().getName() + ": Continuando.");
            System.out.println("= " + Thread.currentThread().getName() + ": Saindo do Produtor =");

        }
    }

    public void consumidor() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("================= " +  Thread.currentThread().getName() + ": Dentro do Consumidor =================");
            System.out.println(Thread.currentThread().getName() + ": Esperando pelo key de retorno");
            scanner.nextLine();
            System.out.println(Thread.currentThread().getName() + ": Chave de retorno pressionada");
            notify();
            System.out.println("= " + Thread.currentThread().getName() + ": Saindo do Consumidor =");
        }
    }



}
