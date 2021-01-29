package br.com.abc.introducao.arrays;

public class Arrays1 {
    public static void main(String[] args) {
        /***
         * ARRAY:
         * variáveis com mais de um espaço de memória, ou seja,
         * não são do tipo primitivo
         * São do tipo Reference, objetos
         *
         */

                            //parâmetro: o tamanho do array
                            // é obrigatório
        int[] idades = new int[3];
        idades[0] = 20;
        idades[1] = 15;
        idades[2] = 30;

        System.out.println(idades[0]);
        System.out.println(idades[1]);
        System.out.println(idades[2]);



    }
}
