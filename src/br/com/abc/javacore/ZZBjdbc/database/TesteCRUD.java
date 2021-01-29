package br.com.abc.javacore.ZZBjdbc.database;

import java.util.Scanner;

public class TesteCRUD {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            menu();
            op = Integer.parseInt(teclado.nextLine());
            if (op == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }

            if (op == 1) {
                menuComprador();
                int opComprador = Integer.parseInt(teclado.nextLine());
                    CompradorCRUD.executar(opComprador);

            }

            if (op == 2) {
                menuCarro();
                int opCarro = Integer.parseInt(teclado.nextLine());
                CarroCRUDImpl.executar(opCarro);

            }

        }
    }

    public static void menu(){
        System.out.println("Digite uma opção para começar");
        System.out.println("1. Comprador");
        System.out.println("2. Carro");
        System.out.println("0. Sair");

    }


    public static void menuComprador(){
        System.out.println("Insira a opcao");
        System.out.println("1. Inserir comprador");
        System.out.println("2. Atualizar comprador");
        System.out.println("3. Listar compradores");
        System.out.println("4. Buscar comprador por nome");
        System.out.println("5. Deletar comprador");
        System.out.println("9. Voltar");
        System.out.println("0. Sair");

    }

    public static void menuCarro(){
        System.out.println("Insira a opcao");
        System.out.println("1. Inserir carro");
        System.out.println("2. Atualizar carro");
        System.out.println("3. Listar carros");
        System.out.println("4. Buscar carro por nome");
        System.out.println("5. Deletar carro");
        System.out.println("9. Voltar");
        System.out.println("0. Sair");

    }







}
