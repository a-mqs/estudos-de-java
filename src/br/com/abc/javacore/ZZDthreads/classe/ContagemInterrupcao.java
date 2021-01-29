package br.com.abc.javacore.ZZDthreads.classe;

/**
 * wait(), notify() e notifyAll()
 *
 * Os 3 métodos acima estabelecem relações
 * entre threads.
 * Em um dado momento de código, o lock de algum método
 * pode precisar ser desbloqueado para outra thread por um
 * tempo. A forma de fazer isso é fazer a thread que
 * está segurando "esperar"(wait()) um pouco onde está e liberar
 * o lock. Passado o lock para outra thread, ela vai usar
 * e quando ela tiver terminado, ela vai "avisar"(notify()) a
 * primeira que terminou, para que a primeira continue seu trabalho.
 *
 * Usando notifyAll(), você avisa a todas as threads do programa
 * sobre usar aquele lock, que está disponível, mas a prioridade é daquela
 * thread que já estava utilizando antes de emprestar. Sendo assim, é
 * mais seguro usar notifyAll(), porque não dá pra saber exatamente qual
 * thread especifica você vai acabar avisando.
 *
 */

public class ContagemInterrupcao {
    final Object lock = new Object();

    public void contagem() throws InterruptedException {
        synchronized (this.lock){
            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
                if (i == 5){
                    /**
                     * Repare: cada objeto possui um lock, então
                     * um foi criado apenas para que sua chave fosse
                     * usada.
                     * Os 3 métodos devem ser chamados a partir
                     * dos locks criados.
                     */
                    lock.wait();
                    i++;
                    System.out.println(i);
                }
                Thread.sleep(1000);
            }
        }
    }

    public void interrupcao() throws InterruptedException {
        synchronized (this.lock){
            Thread.sleep(2000);
            System.out.println("Ué, já deu os 5?");
            Thread.sleep(400);
            System.out.println(".");
            Thread.sleep(400);
            System.out.println("..");
            Thread.sleep(400);
            System.out.println("...");
            Thread.sleep(400);
            System.out.println("Okay, já pode voltar pra lá");
            lock.notifyAll();

        }


    }
}
