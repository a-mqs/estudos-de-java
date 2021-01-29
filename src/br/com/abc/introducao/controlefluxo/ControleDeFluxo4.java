package br.com.abc.introducao.controlefluxo;

public class ControleDeFluxo4 {
    public static void main(String[] args) {

        /***
         * ESTRUTURA DE REPETIÇÃO: WHILE
         *  Enquanto o que ta dentro do parênteses for
         *  verdade, o código será executado
         *
         *  Usado quando você não tem certeza de quantas vezes
         *  vai precisar repetir uma iteração (pedaço de código)
         */

        int contadorWhile = 0;
        while(contadorWhile < 10){
            System.out.println(contadorWhile);
            contadorWhile++;
        }

         /* while infinito
                while(true){
                    System.out.println(contador++);
        */

        /***
         * ESTRUTURA DE REPETIÇÃO: DO WHILE
         *  Uma ordem é dada. Se a condição dentro do while
         *  for true, ela será executada novamente
         *
         *  Usado quando você não tem certeza de quantas vezes
         *  vai precisar repetir uma iteração (pedaço de código)
         */

        int contadorDoWhile = 11;
        do{
            System.out.println("Inside do while");
        } while (contadorDoWhile < 10);

        /***
         * FOR:
         * for(declaração de variável, condição; ação que vem depois do "Faça algo);
         *  //Faça algo
         * Usado quando você sabede quantas vezes
         * vai precisar repetir uma iteração (pedaço de código)
         */

        for(int i = 0; i < 10; i++){
            System.out.println("Valor de i é: " + i);
            //tambem podemos usar break aqui
            if(i==5){
                break;
            }
        }

    }
}
