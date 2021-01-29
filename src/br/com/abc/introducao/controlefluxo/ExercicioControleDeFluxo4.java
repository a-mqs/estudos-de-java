package br.com.abc.introducao.controlefluxo;

public class ExercicioControleDeFluxo4 {
    public static void main(String[] args) {
        /***
         * IMPRIMA TODOS OS NÚMEROS PARES DE 0 A 100000
         */

        for(int numerosPares = 0; numerosPares % 2 == 0 && numerosPares <= 100000; numerosPares += 2){
            System.out.println(numerosPares);


        }
    }
}
