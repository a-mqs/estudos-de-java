package br.com.abc.introducao.arrays;

public class Array6 {
    public static void main(String[] args) {
//        int[][] dias = new int[3][];
//        dias[0] = new int[2];
//        dias[1] = new int[]{1, 2, 3};
//        dias[2] = new int[4];

        /***
         * Forma alternativa e menos extensa:
         */

        int[][] dias = {{0,0}, {1,2,3}, {0,0,0,0}};

        for(int[] indiceExterno : dias){
            for(int indiceInterno : indiceExterno){
                System.out.println(indiceInterno);
            }
        }


    }
}
