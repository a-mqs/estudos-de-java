package br.com.abc.javacore.ZZGcomportamentoporparametro.Livraria;

import java.util.Calendar;

public class LivrosDezAnosRecentesPredicate implements LivroPredicate {
    @Override
    public boolean compare(Livro livro) {
        return livro.getAno() >= Calendar.getInstance().get(Calendar.YEAR) - 10;
    }
}
