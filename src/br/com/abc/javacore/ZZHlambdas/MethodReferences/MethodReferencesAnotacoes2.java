package br.com.abc.javacore.ZZHlambdas.MethodReferences;

import br.com.abc.javacore.ZZHlambdas.Livraria.Livro;
import br.com.abc.javacore.ZZHlambdas.classe.Carro;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static java.util.Arrays.asList;

public class MethodReferencesAnotacoes2 {
    @Override
    public String toString() {
        return "MethodReferencesAnotacoes2{}";
    }

    public static void main(String[] args) {
        List<Carro> carros = asList(
                new Carro("Vermelho", 2000),
                new Carro("Laranja", 2001),
                new Carro("Amarelo", 2002),
                new Carro("Verde", 2003),
                new Carro("Anil", 2004),
                new Carro("Azul", 2005),
                new Carro("Roxo", 2006)
        );

        /**
         * 1- REFERENCIA A UM METODO ESTÁTICO
         *
         * Quando um método estático já está pronto com tudo
         * o que você precisa fazer e ele mora dentro de
         * uma interface ou uma classe, esse método pode ser chamado por
         * method reference. Fica da seguinte forma:
         * Classe::metodo
         */
        carros.sort(ComparadorCarro::comparePorCor);

        /**
         * 2- REFERENCIA A INSTANCIA DO METODO POR UM OBJETO PARTICULAR
         * (Ô nomezinho feio da porra)
         *
         * Isso faz a mesma coisa que o exemplo anterior, porém com
         * um objeto qualquer dessa vez.
         */
        ComparadorCarro comparadorCarroObjeto = new ComparadorCarro();



        carros.sort(comparadorCarroObjeto::comparePorAno);


        /**
         * Esse é bom, vai:
         * 3- REFERENCIA A INSTANCIA DE UM METODO DE UM OBJETO
         * ARBITRARIO DE UM TIPO PARTICULAR
         * (mano dnjfsuihfidf)
         *
         * É quase a mesma coisa que o primeiro, mas lidando com métodos
         * não-estáticos. Bastante útil quando você quer usar
         * métodos de classes comuns, como a String.
         */
        List<String> cores = asList("Vermelho", "Laranja", "Amarelo", "Verde", "Anil",
                "Azul", "Roxo");

        cores.sort(String::compareTo);

        UnaryOperator<String> unaryOperator = String::toUpperCase;
        System.out.println(unaryOperator.apply("banana"));


        /**
         * 4- REFERENCIA A UM CONSTRUTOR
         *
         * O tipo de method reference que cria objetos.
         *
         * Usando Supplier você pode criar um objeto se
         * ele não tiver algum construtor para ser preenchido
         * obrigatoriamente.
         *
         * Se tiver construtor e for obrigatório preenchê-lo,
         * então você só poderá usar method reference se
         * tiver até 2 parâmetros. Para criar com um parâmetro
         * deve ser usada Function, com a entrada do tipo do
         * parametro e a saída do tipo do objeto e BiFunction,
         * da mesma forma, mas com duas entradas para parametros.
         *
         */
        Supplier<ComparadorCarro> supplier = ComparadorCarro::new;

        supplier.get();

        // Não funciona
//        Function<String, Livro> function = Livro::new;

        //
        BiFunction<String, Integer, Carro> biFunction = Carro::new;
        System.out.println(biFunction.apply("Roxo", 2020));


    }





}
