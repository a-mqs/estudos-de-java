package br.com.abc.introducao.arrays;

public class Arrays2 {
    public static void main(String[] args) {

        /*Nenhuma variável declarada, sendo assim,
          por ser inteiro, vai começar com 0
         */
        int[] idades = new int[1];
        System.out.println(idades[0]);

        boolean[] verdadeOuFalso = new boolean[1];
        System.out.println(verdadeOuFalso[0]);

        char[] caractereVazio = new char[1];
        System.out.println(caractereVazio[0]);

        String[] stringEObjeto = new String[1];
        System.out.println(stringEObjeto[0]);


        /***
         * VALORES PADRÃO DE INICIALIZAÇÃO:
         * byte, short, int, long, float, double = 0
         * char = ' "
         * boolean = false
         * Arrays reference = null
         */

        /***
         * Juntando isso com um for (inicialização automática
         */

        //Espaço entre código anterior e próximo
        System.out.println();

        String[] nomes = new String[3];
        nomes[0] = "Goku";
        nomes[1] = "Naruto";
        nomes[2] = "Natsu";

        //Comando para retornar o tamanho do array
        System.out.println("O tamanho desse array é: " + nomes.length);

        for (int contagemDeIndices = 0; contagemDeIndices < nomes.length; contagemDeIndices++) {
            System.out.println(nomes[contagemDeIndices]);
        }

    }
}