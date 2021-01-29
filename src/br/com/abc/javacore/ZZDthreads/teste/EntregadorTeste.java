package br.com.abc.javacore.ZZDthreads.teste;

import br.com.abc.javacore.ZZDthreads.classe.Entregador;
import br.com.abc.javacore.ZZDthreads.classe.ListaMembros;

import javax.swing.*;

public class EntregadorTeste {
    public static void main(String[] args) {
        ListaMembros listaMembros = new ListaMembros();
        Thread t1 = new Thread(new Entregador(listaMembros), "Entregador-1");
        Thread t2 = new Thread(new Entregador(listaMembros), "Entregador-2");

        t1.start();
        t2.start();

        while (true){
            String enderecoEmail = JOptionPane.showInputDialog("Digite o email do membro: ");
            if (enderecoEmail == null || enderecoEmail.isEmpty()){
                listaMembros.fecharLista();
                break;
            }
            listaMembros.adicionarEmailMembro(enderecoEmail);
        }

    }
}
