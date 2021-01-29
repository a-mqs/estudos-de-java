package br.com.abc.javacore.ZZBjdbc.database;

import br.com.abc.javacore.ZZBjdbc.classe.Comprador;
import br.com.abc.javacore.ZZBjdbc.database.CompradorDAO;

import java.util.List;
import java.util.Scanner;

public class CompradorCRUD {
    private static Scanner teclado = new Scanner(System.in);

    public static void executar(int op){
        switch (op) {
            case 1:
                inserir();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listar();
                break;
            case 4:
                System.out.print("Encontre um nome na lista: ");
                procurarPorNome(teclado.nextLine());
                break;
            case 5:
                deletar();
                break;

        }
    }

    public static void inserir(){
        Comprador comprador = new Comprador();
        System.out.print("Insira aqui o nome do comprador: ");
        comprador.setNome(teclado.nextLine());
        System.out.print("Insira aqui o cpf do comprador: ");
        comprador.setCpf(teclado.nextLine());
        System.out.println(comprador);
        System.out.print("Deseja mesmo adicionar esse comprador a lista? (S/N): ");
        String opcao = teclado.nextLine();
        if (opcao.equalsIgnoreCase("s")){
            CompradorDAO.save(comprador);
        }

    }

    public static List<Comprador> listar(){
        List<Comprador> compradorList = CompradorDAO.selectAll();
        for (int i = 1; i < compradorList.size(); i++) {
            Comprador comprador = compradorList.get(i);
            System.out.println("[" + i + "] " + comprador.getNome() + " " + comprador.getCpf());
        }

        return compradorList;
    }

    public static void atualizar(){
        List<Comprador> compradorList = listar();
        System.out.print("Insira o numero do comprador que quer atualizar: ");
        Comprador comprador = compradorList.get(Integer.parseInt(teclado.nextLine()));

        System.out.print("Insira o novo nome ou enter para manter o mesmo: ");
        String nome = teclado.nextLine();

        System.out.print("Insira o novo cpf ou enter para manter o mesmo: ");
        String cpf = teclado.nextLine();

        if (!nome.isEmpty()){
            comprador.setNome(nome);
        }

        if (!cpf.isEmpty()){
            comprador.setCpf(cpf);
        }

        CompradorDAO.update(comprador);
    }

    public static void procurarPorNome(String pedacoNome){
        List<Comprador> compradorList = CompradorDAO.searchByName(pedacoNome);
        for (int i = 1; i < compradorList.size(); i++) {
            Comprador comprador = compradorList.get(i);
            System.out.println("[" + i + "] " + comprador.getNome() + " " + comprador.getCpf());
        }
    }

    public static void deletar(){
        List<Comprador> compradorList = listar();
        System.out.print("Escolha um comprador pra deletar pelo numero: ");
        Comprador comprador = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Tem certeza disso? (S/N): ");
        String certeza = teclado.nextLine();
        if (certeza.equalsIgnoreCase("s")){
            CompradorDAO.delete(comprador);
        }

    }


}
