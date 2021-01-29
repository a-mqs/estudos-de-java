package br.com.abc.introducao.arrays;

public class Arrays5 {
    public static void main(String[] args) {

        /***
         * ARRAYS MULTIDIMENSIONAIS:
         * Arrays nos quais os espaços de memórias são ocupados
         * com outros arrays, não com variáveis
         */


        int[][] dias = new int[2][2];
        //primeiro array
        dias[0][0] = 30;
        dias[0][1] = 31;
        //segundo arrsy
        dias[1][0] = 29;
        dias[1][1] = 28;

        for(int numeroIndice = 0; numeroIndice < dias.length; numeroIndice++){
            System.out.println(dias[numeroIndice]);
//            Nesse caso, serão mostrados os endereços de memória
//            [I@1b6d3586
//            [I@4554617c
//            isso quer dizer que estamos exibindo os resultados do primeiro
//            array, agora, devemos mostrar o resultados dos outros que
//            estão abrigados nesses endereços
                for(int numeroIndiceArraysSeguintes = 0; numeroIndiceArraysSeguintes < dias[numeroIndice].length;
                    numeroIndiceArraysSeguintes++){
                    System.out.println(dias[numeroIndice][numeroIndiceArraysSeguintes]);
                }

//                Com for each
                for(int[] referencia : dias){
                    for(int dia : referencia){
                        System.out.println(dia);
                    }

                }


        }






    }
}
