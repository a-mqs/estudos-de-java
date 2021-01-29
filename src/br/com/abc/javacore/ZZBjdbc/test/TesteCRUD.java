package br.com.abc.javacore.ZZBjdbc.test;




import java.util.Scanner;

public class TesteCRUD {
    private static Scanner teclado = new Scanner(System.in); //Variavel static private do tipo Scanner com nome de teclado
                                                             //q foi inicializado usando o System.io p pegar os dados digitados
                                                             //no console

    public static void main(String[] args) {
        int op;
        while (true) {
            menu();
            op = Integer.parseInt(teclado.nextLine());
            if (op == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }
            if(op == 1){
                menuComprador();
                op = Integer.parseInt(teclado.nextLine());   //Lê cm String e converte p int. Isso pq ele considera o enter uma
                                                             //String ao apertar junto com o num., nisso acaba bugando o processo
                CompradorCRUD.executar(op);
            }
            if(op == 2){
                menuCarro();
                op = Integer.parseInt(teclado.nextLine());
//                CarroCRUDImpl.executar(op);
            }
        }

    }

    private static void menu(){
        System.out.println("Seleciona uma opção: ");
        System.out.println("1. Comprador ");
        System.out.println("2. Carro");
        System.out.println("0. Sair");
    }



    private static void menuComprador() {
        System.out.println("Digite a opção para começar");
        System.out.println("1. Inserir comprador");
        System.out.println("2. Atualizar comprador");
        System.out.println("3. Listar todos os compradores");
        System.out.println("4. Buscar comprador por nome");
        System.out.println("5. Deletar");
        System.out.println("9. Voltar");
        System.out.println("0. Sair");


    }

    private static void menuCarro() {
        System.out.println("Digite a opção para começar");
        System.out.println("1. Inserir carro");
        System.out.println("2. Atualizar carro");
        System.out.println("3. Listar todos os carros");
        System.out.println("4. Buscar carro por nome");
        System.out.println("5. Deletar");
        System.out.println("9. Voltar");
        System.out.println("0. Sair");


    }
}
