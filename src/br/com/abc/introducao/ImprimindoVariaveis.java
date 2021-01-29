package br.com.abc.introducao;

public class ImprimindoVariaveis {
    //Comentários de uma linha

    /*
    Comentários
    de várias
    linhas
    */

    /***
     * Comentário Oficial do Java
     * parâmetro de entrada do método main
     */
     public static void main (String[] args){
         /***
          * VARIÁVEIS

         int idade = 10; //valores inteiros
         double salarioDouble = 3000;//valores quebrados
         float salarioFloat = 3000;//double, mas econômico
         boolean verdadeiro = true;
         boolean falso = false;
         char caractere = '\u0041'; // CARACTERE, <2BYTES, HEXADECIMAL
         byte idadeByte = 12; //valores em 8 bits
         short idadeShort = 32767;//valores em 16 bits
         long numeroLongo = 1000000000000000000000000000000L;//numeros longos
         String name = "Amanda";//palavras
          */



         String nome = "Amanda";
         String rua = "Agostinho Felix Vieira, nº 330, casa 5";
         String telefone = "(21) 86102121";//telefones são strings por terem código de área

         System.out.println(nome + ", domiciliado no endereço "
                 + rua + " e telefone " + telefone + " não possui nenhum tipo de pendência");
     }
}
