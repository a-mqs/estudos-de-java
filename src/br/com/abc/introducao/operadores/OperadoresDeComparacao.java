package br.com.abc.introducao.operadores;

public class OperadoresDeComparacao {
    public static void main (String[] args){

        /***
         * SÍMBOLOS:
         *
         * > ¬ Maior que
         * < ¬ Menor que
         * <= Maior ou igual a
         * >= Menor ou igual a
         * == ¬ igualdade
         * != ¬ diferença
         */

        boolean dezMaiorQueVinte = 10 > 20; //Resultado: false
        boolean dezMenorOuIgualAVinte = 10<=20;
        boolean cincoIgualCinco = 5==5;
        boolean cincoDiferenteCinco = 5!=5;

        System.out.println(dezMaiorQueVinte);
        System.out.println(dezMenorOuIgualAVinte);
        System.out.println(cincoIgualCinco);
        System.out.println(cincoDiferenteCinco);
    }

}
