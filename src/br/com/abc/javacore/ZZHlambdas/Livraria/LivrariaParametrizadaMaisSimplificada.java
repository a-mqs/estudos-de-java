package br.com.abc.javacore.ZZHlambdas.Livraria;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Arrays.asList;

public class LivrariaParametrizadaMaisSimplificada {
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


        /**
         * Agora vamos transformar tudo isso em lambdas
         */

        // Cliente: eu quero livros dos ultimos 10 anos
        System.out.println(filtrarLivros(livros,
                (Livro livro) -> livro.getAno() >= Calendar.getInstance().get(Calendar.YEAR) - 10));

        // Cliente: eu quero que me recomendem alguns livros
        System.out.println(filtrarLivros(livros,
                (Livro livro) -> livro.getNome().equals("Percy Jackson e o Ladrão de Raios") ||
                    livro.getNome().equals("Percy Jackson e a Maldição do Titã") ||
                    livro.getNome().equals("A Revolução dos Bichos") ||
                    livro.getNome().equals("Eclipse")

                )
        );

        // Cliente: quero livros de romance
        System.out.println(filtrarLivros(livros, (Livro livro) -> livro.getGenero().equals("Romance")));

        // Cliente: "Quero os livros do Rick Riordan"
        System.out.println(filtrarLivros(livros, (Livro livro) -> livro.getAutor().equals("Rick Riordan")));



    }



    public static List<Livro> filtrarLivros (List<Livro> livros, LivroPredicate livroPredicate){
        List<Livro> livroList = new ArrayList<>();

        for (Livro livro : livros){
            if (livroPredicate.compare(livro)){
                livroList.add(livro);
            }
        }

        return livroList;
    }
}
