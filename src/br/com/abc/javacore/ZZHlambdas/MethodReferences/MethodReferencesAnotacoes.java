package br.com.abc.javacore.ZZHlambdas.MethodReferences;


import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;
import br.com.abc.javacore.ZZIdefault.classes.C;
import kiddincodes.classes.Animal;

import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;

/**
 * METHOD REFERENCES
 * Formas mais compactas de se escrever métodos
 * em lambdas. Há quatro tipos, que vamos ver abaixo:
 */
public class MethodReferencesAnotacoes {
    public static void main(String[] args) {
        /**
         * 1- REFERENCIA A UM METODO ESTÁTICO
         *
         * Quando um método estático já está pronto com tudo
         * o que você precisa fazer e ele mora dentro de
         * uma interface ou uma classe, esse método pode ser chamado por
         * method reference. Fica da seguinte forma:
         * Classe::metodo
         */
        Pessoa namjoon = new Pessoa("Namjoon", "Kim", 24);
        Pessoa jin = new Pessoa("Seokjin", "Kim", 27);
        Pessoa yoongi = new Pessoa("Yoongi", "Min", 26);
        Pessoa hobi = new Pessoa("Hoseok", "Jung", 24);
        Pessoa jimin = new Pessoa("Jimin", "Park", 23);
        Pessoa taehyung = new Pessoa("Taehyung", "Kim", 23);
        Pessoa jungook = new Pessoa("Jungkook", "Jeon", 21);


        Consumer<Pessoa> btsConsumer1 = Pessoa::apresentacaoStatic;

        btsConsumer1.accept(jin);

        System.out.println("");

        /**
         * 2- REFERENCIA A INSTANCIA DO METODO POR UM OBJETO PARTICULAR
         * (Ô nomezinho feio da porra)
         *
         * Isso faz a mesma coisa que o exemplo anterior, porém com
         * um objeto qualquer dessa vez.
         *
         */

        Pessoa pessoa = new Pessoa(null, null, 0);

        // Note que aqui foi passado o objeto pessoa, uma coisa generica
        Consumer<Pessoa> btsConsumer2 = pessoa::apresentacaoNormalParametro;

        // E através desse objeto pessoa, podemos passar qualquer objeto
        btsConsumer2.accept(jin);

        System.out.println("");

        /**
         * Esse é bom, vai:
         * 3- REFERENCIA A INSTANCIA DE UM METODO DE UM OBJETO
         * ARBITRARIO DE UM TIPO PARTICULAR
         * (mano dnjfsuihfidf)
         *
         * É quase a mesma coisa que o primeiro, mas lidando com métodos
         * não-estáticos. A diferença é que no primeiro, o tipo passado no
         * <> da interface será usado como parâmetro para função estática.
         * Já aqui, o próprio parâmetro chamará o método, pois ele é
         * associado ao objeto, não à classe.
         *
         * Bastante útil quando você quer usar
         * métodos de classes comuns, como a String.
         */

        Consumer<Pessoa> btsConsumer3 = Pessoa::apresentacaoNormal;
        btsConsumer3.accept(taehyung);

        UnaryOperator<String> stringUnaryOperator = String::toUpperCase;
        System.out.println(stringUnaryOperator.apply("Namjoon"));

        System.out.println("");


        /**
         * A DIFERENÇA ENTRE OS TRÊS
         *
         * Para entender melhor a diferença entre os 3 acima,
         * você feve olhar os métodos de ação da classe Pessoa
         */


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

        System.out.println("");

        // Classe Animal, sem construtor
        Supplier<Animal> supplier = Animal::new;
        supplier.get().corre();

        // Classe carro, com construtor de 2 parâmetros
        BiFunction<String, Integer, Carro> biFunction = Carro::new;
        System.out.println(biFunction.apply("Roxo", 2019));


    }


}


