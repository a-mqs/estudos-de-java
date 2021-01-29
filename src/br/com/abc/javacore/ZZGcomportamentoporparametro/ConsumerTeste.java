package br.com.abc.javacore.ZZGcomportamentoporparametro;

import br.com.abc.javacore.ZZGcomportamentoporparametro.Livraria.Livro;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerTeste {
    public static void main(String[] args) {
        Consumer<Integer> dobro = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int dobro = integer * 2;
                System.out.println("O dobro de " + integer + " é " + dobro);
            }
        };

        Consumer<Integer> dobroLambda = (Integer integer) -> {
            int dobroInside = integer * 2;
            System.out.println("O dobro de " + integer + " é " + dobroInside);
        };


        dobro.accept(10);
        dobroLambda.accept(10);


    }
}
