package br.com.abc.javacore.ZZHlambdas.teste;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * INTERFACES FUNCIONAIS
 * Interfaces que só tem apenas um método
 * ou
 * Interfaces que tem inúmeros métodos caracterizados
 * como default, exceto um.
 *
 * Apareceram nas atualizações do Java quando inúmeros
 * desenvolvedores estavam usando as interfaces padrões e
 * se essas interfaces fossem incrementadas com mais métodos,
 * todas as derivadas dessas também deveriam ser. Isso seria
 * um problemão, já que inúmeros desenvolvedores já nem tinham
 * mais acesso a tais códigos. Ia quebrar vários codigos ao
 * redor do mundo.
 *
 * A solução que acharam foi incrementar as interfaces com
 * mais métodos sim, mas usando o modificador default antes
 * dos novos. Isso torna obrigatória a implementação do
 * método não-default e opcional as dos default. Se você
 * quiser usar apenas um default, terá que usar também o
 * não-default.
 */

public class InterfacesFuncionais {
    public static void main(String[] args) {
        // ao invés de ser assim
                            // Target type: o dado que o argumento
                            // está esperando, que, se for correspondente
                            // com o contexto e mais de uma interface tiverem
                            // esses dados, ambas podem ser utilizads
                            // Ex: utilizar CarroPredicate, com o parametro
        //                  // carro e Predicate, com o parâmetro T,
                            // generico, que pode ser mudado pra CarroOptional
                            // Functional Descriptor: o que a função tá
                            // pedindo, no caso da Predicate/CarroPredicate,
                            // o método test
        Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
                    // Lembrando: é necessário ter a variavel e
                    // a chamada do médoto da interface
        System.out.println(pares.test(1000));
        IntPredicate impar = (int i) -> i % 2 == 1;
        System.out.println(impar.test(1000));






    }
}
