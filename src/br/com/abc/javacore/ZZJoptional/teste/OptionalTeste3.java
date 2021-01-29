package br.com.abc.javacore.ZZJoptional.teste;

import br.com.abc.javacore.ZZJoptional.classes.PessoaOptional;

import java.util.Optional;

/**
 * CONSIDERAÇÕES SOBRE OS OPTIONALS
 */

public class OptionalTeste3 {
    public static void main(String[] args) {
        PessoaOptional pessoa = new PessoaOptional();
        pessoa.setNome(null);

        /**
         * Quando você está lidando com atributos
         * que podem vir a ser nulos, vale a pena
         * você usar o optional parz encapsular eles
         */
        // ao invés de apenas:
        System.out.println(pessoa.getNome());

        // Usar:
        System.out.println(Optional.ofNullable(pessoa.getNome()));

        /**
         *
         */
    }

}
