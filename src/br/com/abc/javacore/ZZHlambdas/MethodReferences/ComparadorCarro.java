package br.com.abc.javacore.ZZHlambdas.MethodReferences;

import br.com.abc.javacore.ZZHlambdas.classe.Carro;

public class ComparadorCarro {
    public static int comparePorCor(Carro c1, Carro c2){
        return c1.getCor().compareTo(c2.getCor());
    }

    public int comparePorAno(Carro c1, Carro c2){
        return Integer.compare(c1.getAno(), c2.getAno());
    }
}
