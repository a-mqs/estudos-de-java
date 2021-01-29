package br.com.abc.introducao.operadores;

public class Operadores {
    public static void main (String[] arg){

        int numero1 = 10;
        int numero2 = 20;

        // Soma
        /***
         * System.out.println(numero1 + numero2);
         */

        /***
         * ERROR:
         * System.out.println("A soma é:" numero1 + numero2);
         * o resultado disso vai dar 1020, não 30
         * porque + usado depois de uma unca vez como concatenação
         * passa a ser apenas concatenação
         *
         * ALTERNATIVA:
         * criar uma variavel soma
         */

        int soma = numero1 + numero2;
        int multiplicacao = numero1 * numero2;
        int divisao = numero1 / numero2;
        int subtracao = numero1 - numero2;
        int restoDaDivisao = numero2 % numero1;

        System.out.println("A soma é:" + soma);

        //Multiplicação *
        System.out.println("A multiplicação é:" + multiplicacao);

        //Divisão /
        System.out.println("A divisao é:" + divisao);

        //Subtração -
        System.out.println("A subtração é:" + subtracao);

        // Resto %
        System.out.println("O resto dessa divisão é:" + restoDaDivisao);
    }
}
