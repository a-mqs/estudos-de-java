package br.com.abc.introducao.controlefluxo;

public class ControleFluxo3 {
    public static void main(String[] args) {

        /***
         * DADOS OS NUMEROS DE 1 A 7, IMPRIMA OS DIAS DA SEMANA
         *
         * SWITCH: usado para comparações simples, mas com várias
         * alternativas
         */

        byte dia = 5;
        String diaDaSemana;

        //variaveis permitidas: char, int, byte, short, enum, string
        switch(dia){
            case 1:
                System.out.println("domingo");
                break;
            case 2:
                System.out.println("segunda");
                break;
            case 3:
                System.out.println("terça");
                break;
            case 4:
                System.out.println("quarta");
                break;
            case 5:
                System.out.println("quinta");
                /*Um switch olha condição por condição, mesmo
                que ele já tenha achado o necessário para
                satisfazer o pedido
                Para evitar que ele olhe código por código
                mesmo depois de já ter encontrado o que queria,
                usa-se o break
                funciona da seguinte forma:
                    No momento em que ele vê um break, ele sai
                    desse bloco de código e vai pro de baixo
                usar break em switch é uma boa prática de
                programação
                */
                break;
            case 6:
                System.out.println("sexta");
                break;
            case 7:
                System.out.println("sábado");
                break;

        }

        char sexo = 'A';

        switch (sexo){
            case 'F':
                System.out.println("Feminino");
                break;
            case 'M':
                System.out.println("Masculino");
                break;
            //Caso nenhuma das opções do case atendam às expectativas:
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}
