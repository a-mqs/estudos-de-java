package br.com.abc.javacore.ZZGcomportamentoporparametro.Concessionaria;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;

import java.util.Calendar;

public class CarrosDezAnosRecentesPredicate implements CarroPredicate {
    /**
     * Implementando a CarroPredicate, podemos colocar uma condição
     * específica aqui
     */
    @Override
    public boolean compare(Carro carro) {
        return carro.getAno() > Calendar.getInstance().get(Calendar.YEAR) - 10;
    }
}
