package br.com.abc.javacore.Zgenerics.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * WILDCAST CORINGA
 * Possibilita que parâmetros de métodos permitam
 * que argumentos façam polimorfismo em listas
 * Deve ser adicionado quando a lista está toda pronta,
 * todos os itens adicionados, porque, após isso, dá erro
 * de compilação a adição de novos itens
 */

abstract class Animal {
    String nome;

    public Animal(String nome){
        this.nome = nome;
    }

    public abstract void consulta();
}

class Cachorro extends Animal{

    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void consulta() {
        System.out.println("Consultando " + nome);
    }
}

class Gato extends Animal {

    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void consulta() {
        System.out.println("Consultando " + nome);
    }
}

public class WildCardTeste {
    public static void main(String[] args) {
        Cachorro cao1 = new Cachorro("Doug");
        Cachorro cao2 = new Cachorro("Felix");

        Gato gato1 = new Gato("Marie");
        Gato gato2 = new Gato("Milles");

        Cachorro[] cachorros = {cao1, cao2};
        Gato[] gatos = {gato1, gato2};
//        consultarAnimais(cachorros);
//        consultarAnimais(gatos);

        // O que se pode concluir?: Em arrays, é possível dar nos argumentos
        // do tipo Classe Pai, argumentos do tipo Classe Filha, pelo
        // polimorfismo

        List<Cachorro> cachorroList = new ArrayList<>();
        cachorroList.add(new Cachorro("Spike"));
        List<Gato> gatoList = new ArrayList<>();
        gatoList.add(new Gato("Tom"));

        consultarAnimaisList(cachorroList);
        consultarAnimaisList(gatoList);

        // Já em Lists, não é possível usar polimorfismo
        // (vai dar erro de compilação), os
        // argumentos devem ser dos mesmos tipos que os
        // parâmetros
        // Isso ocorre porque na hora de transformar as classes
        // em bytecode, os generics são ignorados
        // Como contornar?: usando o Wildcard (?)


    }

    public static void consultarAnimais(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    // Para que qualquer filha de animal possa servir de argumento:
                                        // Java falando: "Eu aceito que você faça
                                        // uma lista de qualquer coisa, sob a
                                        // condição dessa qualquer coisa ser filha de Animal,
                                        // mas nada poderá ser adicionado a essa lista"
    public static void consultarAnimaisList(List<? extends Animal> animais){
        for (Animal animal : animais) {
            animal.consulta();
        }

        // O tracinho vermelho fica aparecendo embaixo, dá erro de compilaçao
        // animais.add(new Cachorro("Spike"));
    }


    // O java não deixa adicionar porque ele não consegue prever
    // o que exatamente o dev vai colocar ali, permitindo-o
    // misturar gato e cachorro

    // Para contornar isso, é possível trabalhar com super, ao invés do extends
    // Nesse caso, você tipando a variável tanto como Cachorro, como Animal e
    // até como Object, é possível você criar um objeto de cachorro
    // Mas veja bem, precisa mesmo ser unicamente um cachorro
    public static void consultarCachorrosList(List<? super Cachorro> cachorroList){
        Cachorro cachorro = new Cachorro("Guido");
        Animal animal = new Cachorro("Hulk");

        cachorroList.add(cachorro);



        System.out.println(cachorroList);


    }

    // Também é possível criar condições para argumentos, por exemblo,
    // permitir a criação de uma lista apenas com itens contendo Comparable
                                // "O argumento apresentado é um comparable?"
    public static void ordenarLista(List<? extends Comparable> lista){
        Collections.sort(lista);
    }
}
