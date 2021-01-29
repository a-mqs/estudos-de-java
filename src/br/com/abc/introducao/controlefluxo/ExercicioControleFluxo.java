package br.com.abc.introducao.controlefluxo;

public class ExercicioControleFluxo {
    public static void main(String[] args) {

        /***
         * CRIAR VARIAVEL SALARIO E IMPRIMIR IMPOSTO
         * Imposto:
         *      salario < 1000 => 5%
         *      salario >= 1000 && salario < 2000 => 10%
         *      salario >= 2000 && salario < 4000 => 15%
         *      salario >= 4000 => 20%
         */

        double salario = 1200;
        double imposto;

        if (salario < 1000){
            imposto = salario * 0.05;
        } else if (salario >= 1000 && salario < 2000) {
            imposto = salario * 0.10;
        } else if (salario >= 2000 && salario < 4000) {
            imposto = salario * 0.15;
        } else {
            imposto = salario * 0.20;
        }

        System.out.println("Valor do salário: " + salario +
                " reais, logo, o imposto a ser pago é de " + imposto + " reais.");
    }
}
