package br.com.abc.javacore.ZZJoptional.teste;

import br.com.abc.javacore.ZZJoptional.classes2.Carro;
import br.com.abc.javacore.ZZJoptional.classes2.Pessoa;
import br.com.abc.javacore.ZZJoptional.classes2.Seguradora;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTeste4 {
    public static void main(String[] args) {
        Seguradora segDevDojo = new Seguradora("Seguradora DevDojo");
        Carro carro = new Carro(segDevDojo, "BMW");
        Pessoa pessoa1 = new Pessoa("Marina", carro, 22);
        Pessoa pessoa2 = new Pessoa("Billie", carro, 17);

        checarNomeSeguradora(segDevDojo, "Seguradora devdojo");

        System.out.println(getSeguradoraComIdade(pessoa1));
        System.out.println(getSeguradoraComIdade(pessoa2));

        /**
         * É possível checar se os valores não são nulos dentro
         * das classes
         */
        Map<String, String> map = new HashMap<>();
        System.out.println(Optional.ofNullable(map.get("aaaa")));

        /**
         * E também é possível usar Optionals como respostas para
         * exceções. Não é uma prática permitida em todos os lugares
         * ou 100% aconselhavel, mas é possível.
         */

        // A "exceção" será lançada se o dígito não for um numero
        System.out.println(stringToInt("A"));

    }



    public static void checarNomeSeguradora(Seguradora seguradora, String nome){
        Optional<Seguradora> seguradoraOptional = Optional.ofNullable(seguradora);
        seguradoraOptional
                // filter(): tem como parametro o Predicate, aqui você estabelece
                // uma condição
                .filter(seg -> seg.getNome().equalsIgnoreCase(nome))
                // ifPresent(): se atendida, alguma coisa deve ser feita
                .ifPresent(x -> System.out.println("É a seguradora " + seguradora.getNome()));
    }

    /**
     * E usando filter() você ainda pode estabelecer condições para as operações
     * serem continuadas
     */
    public static String getSeguradoraComIdade(Pessoa pessoa){
        Optional<Pessoa> pessoaOptional = Optional.ofNullable(pessoa);
         return pessoaOptional
                .filter(p -> pessoa.getIdade() >= 18)
                .flatMap(Pessoa::getCarro)
                .flatMap(Carro::getSeguradora)
                .map(Seguradora::getNome)
                .orElse("Não existe seguradora ou idade mínima não alcançada");
    }

    /**
     * E também é possível usar Optionals como respostas para
     * exceções. Não é uma prática permitida em todos os lugares
     * ou 100% aconselhavel, mas é possível.
     */
    public static Optional<Integer> stringToInt(String numero){
        try {
            return Optional.of(Integer.parseInt(numero));
        } catch (NumberFormatException e){
            return Optional.empty();
        }
    }

}
