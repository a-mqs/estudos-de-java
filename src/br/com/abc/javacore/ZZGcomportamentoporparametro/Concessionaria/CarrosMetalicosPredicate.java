package br.com.abc.javacore.ZZGcomportamentoporparametro.Concessionaria;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;

public class CarrosMetalicosPredicate implements CarroPredicate {
    @Override
    public boolean compare(Carro carro) {
        return carro.getCor().equalsIgnoreCase("Dourado") ||
                carro.getCor().equalsIgnoreCase("Prata") ||
                carro.getCor().equalsIgnoreCase("Bronze") ||
                carro.getCor().equalsIgnoreCase("Cobre");
    }
}
