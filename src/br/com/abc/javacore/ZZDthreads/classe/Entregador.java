package br.com.abc.javacore.ZZDthreads.classe;


public class Entregador implements Runnable{
    private ListaMembros listaMembros;

    public Entregador(ListaMembros listaMembros) {
        this.listaMembros = listaMembros;
    }

    @Override
    public void run() {
        String nomeThread = Thread.currentThread().getName();
        System.out.println(nomeThread + " Começando o trabalho de entrega");
        int qtdePendente = listaMembros.getEmailsPendentes();
        boolean aberta = listaMembros.isAberta();
        while (aberta || qtdePendente > 0){
            String enderecoEmail = listaMembros.obterEmailMembro();
            try {
                if (enderecoEmail != null){
                    System.out.println(nomeThread + " enviando email para " + enderecoEmail);
                    Thread.sleep(2000);
                    System.out.println("Envio para " + enderecoEmail + " concluido com sucesso.");
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
            aberta = listaMembros.isAberta();
            qtdePendente = listaMembros.getEmailsPendentes();
        }
        System.out.println("Ações finalizadas");
    }
}
