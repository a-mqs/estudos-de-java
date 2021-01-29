package br.com.abc.javacore.ZZGcomportamentoporparametro.Livraria;

public class LivrosFavoritosDaEquipePredicate implements LivroPredicate {
    @Override
    public boolean compare(Livro livro) {
        return livro.getNome().equals("Percy Jackson e o Ladrão de Raios") ||
                livro.getNome().equals("Percy Jackson e a Maldição do Titã") ||
                livro.getNome().equals("A Revolução dos Bichos") ||
                livro.getNome().equals("Eclipse");
    }
}
