package br.com.abc.javacore.ZZHlambdas;

import kiddincodes.Lambda.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;

/**
 * Eu tava tentando entender como a interface
 * Function funciona (isso de entrar um tipo pra
 * sair outro simplesmente não tava entrando) e
 *
 * Achei tão fofo que resolvi guardar <333
 */

public class BTSFunction {
    public static void main(String[] args) {
        List<Pessoa> bts = asList(
                new Pessoa("Namjoon", "Kim", 24),
                new Pessoa("Seokjin", "Kim", 27),
                new Pessoa("Yoongi", "Min", 26),
                new Pessoa("Hoseok", "Jung", 24),
                new Pessoa("Jimin", "Park", 23),
                new Pessoa("Taehyung", "Kim", 23),
                new Pessoa("Jungkook", "Jeon", 21)
        );

        System.out.println(btsNomes(bts,
                // A coisa que decidimos fazer aqui foi pegar o sobrenome e o nome pra retornar ambos juntos
                (Pessoa integrante) -> integrante.getSobrenome() + " " + integrante.getNome()));


    }


    public static List<String> btsNomes(List<Pessoa> integrantes, Function<Pessoa, String> pessoaStringFunction) {
        List<String> stringList = new ArrayList<>();
        // Para cada integrante...
        for (Pessoa integrante : integrantes) {
            // Vamos pegar alguma coisa deles, talvez um
            // nome ou sobrenome, não sei, só sei que vai
            // ser uma coisa do tipo String
            // Depois disso vamos adicionar essa string a
            // stringList
            stringList.add(pessoaStringFunction.apply(integrante));

        }

        return stringList;
    }

}
