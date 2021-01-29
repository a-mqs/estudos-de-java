package br.com.abc.javacore.ZZHlambdas;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

/**
 * Essa classe contém algumas informações importantes
 * sobre lambdas
 */

public class Anotacoes {
    public static void main(String[] args) throws Exception {
        /**
         * 1- INTERFACES FUNCIONAIS PARA TIPOS PRIMITIVOS
         * Quando você quer trabalhar com altíssima performance
         * (pode ser útil um dia), você pode usar tais interfaces.
         * Elas não gastam tanto processamento quanto Wrappers,
         * já que um Wrapper precisa fazer o autoboxing (adaptar
         * o tipo primitivo a uma classe), então vale a pena usar.
         *
         * Tem pros tipos int, long e double
         **/

        IntPredicate isImpar = (int i) -> i % 2 != 0;
        System.out.println("O número é ímpar?: " + isImpar.test(11));


        /**
         * 2- FUNCTIONAL DESCRIPTOR E TARGET TYPE
         * Functional descriptor: como é chamada a assinatura
         * do(s) método(s) de uma interface funcional, ou seja,
         * é o formato que aquele método tem (modificador de acesso,
         * modificador estático, tipo, nome, parâmetros, esses
         * componentes juntos formam a assinatura do método)
         *
         * Target Type: é a capacidade do compilador do Java
         * inferir qual tipo de dado você cai usar com base
         * em um contexto em que você está utilizando um
         * tipo específico de dado.
         * Tipo:
         * List<Integer> listInteger = new ArrayList<>();
         * Pelo tipo da lista ser Integer, o proprio compilador
         * vai assumir que o objeto ArrayList também será
         * do tipo Integer.
         *
         * Se uma interface tiver o mesmo functional descriptor e
         * o mesmo target type de outra, uma poderá ficar no lugar
         * da outra caso necessário, ou ambas podem receber o mesmo
         * lambda
         */

        // A interface Callable tem o metodo V call()
        Callable<String> palavraCallable = () -> "palavraCallable";
        // A interface PrivilegedAction tem o método T run()
        PrivilegedAction<String> palavraPrivilegedAction = () -> "palavraPrivilegedAction";

        System.out.println(palavraCallable.call());
        System.out.println(palavraPrivilegedAction.run());

        // Já que eles tem mesma function descriptor e mesmo type checking,
        // dá pra colocar o lambda de um em outro
        Callable<String> palavraPrivilegedAction1  = () -> "palavraPrivilegedAction";
        PrivilegedAction<String> palavraCallable1 = () -> "palavraCallable";

        System.out.println(palavraCallable.call());
        System.out.println(palavraPrivilegedAction.run());

        /**
         * 3- FUNÇÕES QUE RETORNAM VOID APARECENDO COMO SE
         * SEUS RETORNOS FOSSEM TIPADOS
         *
         * Em teoria, é possível fazer ações com retorno
         * mesmo dentro de uma função void.
         */

        List<String> cores = new ArrayList<>();
        Predicate<String> adicionarCorPredicate = (String string) -> cores.add(string);
        Consumer<String> adicionarCorConsumer = (String string) -> cores.add(string);

        adicionarCorPredicate.test("cinza");
        adicionarCorConsumer.accept("marrom");

        System.out.println(cores);

        /**
         * 4- O TIPO NÃO PRECISA SER COLOCADO NOS PARAMETROS
         * DA LAMBDA SEMPRE
         * Pela habilidade target type do compilador, ele consegue
         * perceber com que tipo de variáveis estamos trabalhando se
         * esses tipos já foram citados antes, então você pode trabalhar
         * apenas com uma variável daquele tipo ao manusear o lambda.
         *
         * Mas lembre-se: só é bom usar parametros concisos assim quando
         * eles estão claros na lambda, ou seja, se sentir que não colocar o
         * tipo vai gerar confusão, melhor colocar. Tenha cuidado com ambiguidades,
         * são más práticas.
         */

        // Ao invés de fazer isso:
        Consumer<String> testeString = (String string) -> System.out.println(string);
        // Você pode fazer apenas isso:
        Consumer<String> testeStringConciso = string -> System.out.println(string);

        testeString.accept("Alô");
        testeStringConciso.accept("Alô");

        /**
         * 5- VARIÁVEIS LOCAIS DENTRO DE LAMBDAS
         * Para passar variáveis locais dentro de parametros
         * de lambdas, deve-se usar a mesma regra de classes
         * anônimas: as tais variáveis devem ser finais ou
         * efetivamente finais, essa ultima sendo variáveis
         * locais que não podem ser alteradas em nenhum momento
         * do código
         *
         */

        List<String> stringList = new ArrayList<>();

        String palavra = "Escorpiao";
        final String palavra1 = "Aquario";
        final String palavra2 = "Peixe";

//        Consumer<String> a = string -> stringList.add(palavra);
        Consumer<String> palavra1Consumer = string -> stringList.add(palavra1);
        Consumer<String> palavra2Consuner = string -> stringList.add(palavra2);


        // Não permitido, pois está mudando uma variavel
        // ja usada como parametro
//        palavra = "banana";

        /**
         * 6- INTERFACE SUPPLIER
         * Contém apenas o método get() e serve para retornar alguma coisa
         */

        Supplier<Carro> supplierCarro = () ->  new Carro("Azul", 2005);

        System.out.println(supplierCarro.get().getAno());

    }










}
