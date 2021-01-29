package br.com.abc.introducao.controlefluxo;

public class ControleDeFluxo2 {
    public static void main(String[] args) {

        int idade = 20;
        String status;

        /***
         * OPERADOR TERNÁRIO
         * Usar apenas para duas condições
         */
        status = idade < 18 ? "Não adulto" : "Adulto" ;



        System.out.println(status);
    }

}
