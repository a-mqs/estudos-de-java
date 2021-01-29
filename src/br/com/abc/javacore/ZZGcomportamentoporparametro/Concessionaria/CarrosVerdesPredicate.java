package br.com.abc.javacore.ZZGcomportamentoporparametro.Concessionaria;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;

public class CarrosVerdesPredicate implements CarroPredicate {
    @Override
    public boolean compare(Carro carro) {
        return carro.getCor().equalsIgnoreCase("Verde");
    }
}
