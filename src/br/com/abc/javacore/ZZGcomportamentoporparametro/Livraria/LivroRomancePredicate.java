package br.com.abc.javacore.ZZGcomportamentoporparametro.Livraria;

public class LivroRomancePredicate implements LivroPredicate {

    @Override
    public boolean compare(Livro livro) {
        return livro.getGenero().equals("Romance");
    }
}
