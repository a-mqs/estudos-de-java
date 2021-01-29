package br.com.abc.introducao.arrays;

public class Arrays3 {
    public static void main(String[] args) {

        //Primeira forma de inicializar um array
        int[] numeros  = new int[5];
        //Segunda forma
        int[] numeros2 = {1, 2, 3, 4, 5};
        //Terceira forma
        int[] numeros3 = new int[] {1, 2, 3, 4, 5};

        /***
         * FOR EACH:
         * for usado pra array
         */

        for(int indiceDoArray : numeros2){
            System.out.println(indiceDoArray);
        }

        //Outro exemplo

        System.out.println();

        String[] nomes = {"Miley", "Selena", "Demi"};

        for(String divas2010 : nomes){
            System.out.println(divas2010);
        }

    }
}
