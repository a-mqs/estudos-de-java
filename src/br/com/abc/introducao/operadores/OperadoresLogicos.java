package br.com.abc.introducao.operadores;

public class OperadoresLogicos {
    public static void main (String[] args){

        /***
         * OPERADORES LÓGICOS: E (&&)| OU (||)
         */

        int idade = 18;
        float salario = 1000f;

        //Condições não atendidas:
         System.out.println(idade >= 18 && salario >= 3000);

        //Condições atendidas:
        System.out.println(idade >= 18 || salario >= 3000);

    }
}
