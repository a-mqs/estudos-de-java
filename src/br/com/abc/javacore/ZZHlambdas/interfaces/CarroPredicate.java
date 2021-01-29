package br.com.abc.javacore.ZZHlambdas.interfaces;


import br.com.abc.javacore.ZZHlambdas.classe.Carro;

/**
 * PARAMETRIZANDO COMPORTAMENTOS
 * Uma boa pratica para filtros, por exemplo.
 * Nesse caso, estamos criando várias classes com base nessa
 * interface predicate, que vão estabelecer filtros para a classe CarroTeste
 * Só é possivel utilizar lambdas com interfaces funcionais
 */

// @FunctionalInterface: interfaces com apenas um método abstrato
@FunctionalInterface
public interface CarroPredicate {
    boolean test(Carro carro);
}
