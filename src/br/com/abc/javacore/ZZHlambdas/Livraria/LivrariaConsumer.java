package br.com.abc.javacore.ZZHlambdas.Livraria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

/**
 * INTERFACE CONSUMER
 * Essa também é uma interface funcional, usada para
 * passar um comportamento por padrão. Diferente do
 * Predicate, essa aqui tem como default o metodo
 * accept, que retorna void e tem como parâmetro
 * T, ou seja, você pode definir o tipo desse parâmetro.
 */

public class LivrariaConsumer {
    public static void main(String[] args) {
        Livro oAnoDoPensamentoMagico =
                new Livro("O ano do pensamento mágico", 2018, "Autobiografia", "Joan Didion");
        Livro filhaDasAbelhas =
                new Livro("Filha das Abelhas", 2019, "Autobiografia", "Meredith May");
        Livro percyJacksonEOLadraoDeRaios =
                new Livro("Percy Jackson e o Ladrão de Raios", 2005, "Aventura", "Rick Riordan");
        Livro percyJacksonEAMaldicaoDoTita =
                new Livro("Percy Jackson e a Maldição do Titã", 2007, "Aventura", "Rick Riordan");
        Livro crepusculo =
                new Livro("Crepúsculo", 2005, "Romance", "Stephenie Meyer");
        Livro eclipse =
                new Livro("Eclipse", 2009, "Romance", "Stephenie Meyer");
        Livro aRevolucaoDosBichos =
                new Livro("A Revolução dos Bichos", 1945, "Sátira Política", "George Orwell");
        Livro aSutilArteDeDizerDizerFdase =
                new Livro("A Sutil Arte de Dizer F*da-se", 2018, "Autoajuda", "Mark Manson");
        Livro felicidadeClandestina =
                new Livro("Felicidade Clandestina", 1971, "Ficção Literária", "Clarice Lispector");


        List<Livro> livros = asList(oAnoDoPensamentoMagico, filhaDasAbelhas, percyJacksonEAMaldicaoDoTita,
                percyJacksonEOLadraoDeRaios, crepusculo, eclipse, aRevolucaoDosBichos,
                aSutilArteDeDizerDizerFdase, felicidadeClandestina);


        // Interessante: note como accept() já tem uma ideia de que vamos mexer com
        // o livro A Sutil Arte de Dizer F*da-se. Isso porque isso já foi definido em cataLivroPraZoar(),
        // que mexeriamos com o livro especificado. Nós só incluímos uma variável
        // livro nesses parenteses para que possamos mexer com o livro especificado, nesse caso
        // A Sutil Arte de Dizer F*da-se,
        cataLivroPraZoar(aSutilArteDeDizerDizerFdase, (livro) -> {
            System.out.println("A equipe vai mudar o titulo para: Propaganda enganosa");
            livro.setNome("Propaganda enganosa");
            System.out.println(livro);
        });


    }

    /**
     * O trabalho da equipe do TI tá tão bom que agora
     * a livraria está deixando que, todos os dias,
     * eles peguem de graça um livro.
     * Eles podem fazer o que quiserem com esse livro
     */

    public static void cataLivroPraZoar(Livro livro, Consumer<Livro> livroConsumer){
        System.out.println("O livro do dia é: " + livro.getNome());
        System.out.println("E o que a equipe vai fazer com esse livro hoje?: ");
        /**
         * Repare aqui.
         *
         * A cada dia a equipe vai ter um comportamento diferente
         * do anterior, decidido na hora, um comportamento que é surpresa
         * e tá fora das expectativas do método. Quando temos comportamentos
         * surpresas assim, o melhor é colocar a melhor interface funcional
         * para aquele comportamento no parâmetro e preencher na hora de
         * chamar a função.
         *
         * Por exemplo: dessa vez só queremos zoar com o livro. Isso não
         * precisa retornar nada, apenas fazer alguma ação. Então a
         * interface mais cabível é a consumer, recebendo um Livro como
         * parametro, já que é com ele que vamos mexer.
         */
        livroConsumer.accept(livro);

    }









}
