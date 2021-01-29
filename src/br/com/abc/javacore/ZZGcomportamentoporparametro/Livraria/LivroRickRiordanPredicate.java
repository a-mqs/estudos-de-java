package br.com.abc.javacore.ZZGcomportamentoporparametro.Livraria;

public class LivroRickRiordanPredicate implements LivroPredicate {
    @Override
    public boolean compare(Livro livro) {
        return livro.getAutor().equals("Rick Riordan");
    }
}
