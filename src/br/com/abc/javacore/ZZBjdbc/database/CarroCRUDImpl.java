package br.com.abc.javacore.ZZBjdbc.database;

import br.com.abc.javacore.ZZBjdbc.classe.Carro;
import br.com.abc.javacore.ZZBjdbc.classe.Comprador;
import br.com.abc.javacore.ZZBjdbc.interfaces.CarroDAO;

import java.util.List;
import java.util.Scanner;


public class CarroCRUDImpl {
    private static Scanner teclado = new Scanner(System.in);
    
    private static CarroDAO dao = new CarroDAOImpl();

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
        Carro carro = new Carro();

        System.out.print("Insira aqui a placa do carro: ");
        carro.setPlaca(teclado.nextLine());

        System.out.print("Insira aqui o nome do carro: ");
        carro.setNome(teclado.nextLine());

        List<Comprador> compradorList = CompradorCRUD.listar();
        System.out.print("Insira aqui o numero de quem vai comprar esse carro: ");
        int compradorIndex = Integer.parseInt(teclado.nextLine());
        Comprador comprador = compradorList.get(compradorIndex);

        dao.save(carro, comprador);

    }

    public static List<Carro> listar(){
        List<Carro> carroList = dao.selectAll();
        for (int i = 1; i < carroList.size(); i++) {
            Carro carro = carroList.get(i);
            System.out.println("[" + i + "] " + carro.getPlaca() + " " + carro.getNome() + " " + carro.getComprador().getId());
        }

        return carroList;
    }

    public static void atualizar(){
        List<Carro> carroList = listar();
        System.out.print("Insira o número do carro que deseja atualizar: ");
        Carro carro = carroList.get(Integer.parseInt(teclado.nextLine()));

        System.out.print("Insira a nova placa ou enter para manter: ");
        String placa = teclado.nextLine();

        System.out.print("Insira o novo nome ou enter para manter: ");
        String nome = teclado.nextLine();

        if (!placa.isEmpty()){
            carro.setPlaca(placa);
        }

        if (!nome.isEmpty()){
            carro.setNome(nome);
        }

        dao.update(carro);
    }

    public static List<Carro> procurarPorNome(String pedacoNome){
        List<Carro> carroList = dao.searchByName(pedacoNome);
        for (int i = 1; i < carroList.size(); i++) {
            Carro carro = carroList.get(i);
            System.out.println("[" + i + "] " + carro.getPlaca() + " " + carro.getNome() + " " + carro.getComprador().getId());
        }

        return carroList;
    }

    public static void deletar(){
        List<Carro> carroList = listar();
        System.out.print("Selecione o numero do carro que você quer deletar: ");
        Carro carro = carroList.get(Integer.parseInt(teclado.nextLine()));
        dao.delete(carro);
    }
}
