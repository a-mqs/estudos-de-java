package br.com.abc.javacore.ZZHlambdas.Livraria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Arrays.asList;

/**
 * INTERFACE FUNCTION
 * Também é uma interface funcional, e essa contém o
 * método apply como abstrato, além de mais opções
 * como default. Essa interface trabalha recebendo
 * um dado T de entrada e retorna um R de saída,
 * ambos determinados pelo desenvolvedor.
 *
 * Até agora se mostrou muito util para coletar
 * atributos em classes
 */

public class LivrariaFunction {
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

        // Okay, no momento ele quer uma lista com todos os autores dos livros cadastrados
        System.out.println(informacaoLivro(livros, (livro) -> livro.getAutor()));

    }

    /**
     * Voltando ao trabalho depois da zoeira, os chefes da equipe
     * pediram que vocês fizessem algo que mostrasse uma lista
     * de informações específicas de cada livro (nome, autor, ano...),
     * dependendo do que eles quisessem no momento.
     */

    public static List<String> informacaoLivro(List<Livro> livros, Function<Livro, String> livroStringFunction){
        List<String> stringList = new ArrayList<>();

        // Para cada livro da lista de livros passados...
        for (Livro livro : livros) {
            // ... você vai fazer alguma coisa com esses livros,
            // que você vai decidir na hora de adicionar os parâmetros
            String result = livroStringFunction.apply(livro);
            // Se a stringList não tiver ainda a coisa que você
            // fez retornar no parâmetro...
            if (!stringList.contains(result)){
                // ... essa coisa será adicionada a stringList
                stringList.add(result);
            }
        }

        return stringList;
    }




}
