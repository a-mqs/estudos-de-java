package br.com.abc.introducao.controlefluxo;

public class ExercicioControleFluxo3 {
    public static void main(String[] args) {
        /***
         * CRIAR UM SWITCH QUE, DADO UM VALOR DE
         * 1 A 7, CONSIDERANDO 1 DOMINGO, IMPRIMA
         * SE É DIA ÚTIL OU FINAL DE SEMANA
         */

        int diaDaSemana = 5;

        switch(diaDaSemana){
            case 1:
                System.out.println("Fim de semana");
                break;
            case 2:
                System.out.println("Dia útil");
                break;
            case 3:
                System.out.println("Dia útil");
                break;
            case 4:
                System.out.println("Dia útil");
                break;
            case 5:
                System.out.println("Dia útil");
                break;
            case 6:
                System.out.println("Dia útil");
                break;
            case 7:
                System.out.println("Fim de semana");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}
