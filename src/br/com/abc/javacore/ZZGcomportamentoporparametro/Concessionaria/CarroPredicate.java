package br.com.abc.javacore.ZZGcomportamentoporparametro.Concessionaria;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;

public interface CarroPredicate {
    /**
     * Okay, já que é tudo bem padronizado, acho
     * que seria uma boa prática a gente pegar aquele
     * modelo de método e transofmar numa interface
     */

    boolean compare(Carro carro);

}
