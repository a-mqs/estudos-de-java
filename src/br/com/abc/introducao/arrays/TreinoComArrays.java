package br.com.abc.introducao.arrays;

import java.util.Arrays;

public class  TreinoComArrays {
    public static void main(String[] args) {

//        int[] numeros0a9 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//        for(int contagemNumeros : numeros0a9){
//            System.out.println(contagemNumeros);
//        }


        String[][] caixaMaior = new String[2][3];
        caixaMaior[0][0] = "caixaAzul1";
        caixaMaior[0][1] = "caixaAzul2";
        caixaMaior[0][2] = "caixaAzul3";
        caixaMaior[1][0] = "caixaVermelha1";
        caixaMaior[1][1] = "caixaVermelha2";
        caixaMaior[1][2] = "caixaVermelha3";

//        for(int contagemIndices = 0; contagemIndices < caixaMaior.length; contagemIndices++){
//            System.out.println(caixaMaior[contagemIndices]);
//            for(int contagemIndicesNext = 0;
//            contagemIndicesNext < caixaMaior[contagemIndices].length; contagemIndicesNext++){
//                System.out.println(caixaMaior[contagemIndices][contagemIndicesNext]);
//            }

        for(String[] indicesExternos : caixaMaior){
            for(String indicesInternos : indicesExternos){
                System.out.println(indicesInternos);
            }
        }


//        Utilidade: método deepToString, tirado da biblioteca java,
//        serve pra percorrer dentro dos arrays
//              System.out.println(Arrays.deepToString(caixaMaior));
        //Resultado: [[caixaAzul1, caixaAzul2, caixaAzul3], [caixaVermelha1, caixaVermelha2, caixaVermelha3]]

        }





}
