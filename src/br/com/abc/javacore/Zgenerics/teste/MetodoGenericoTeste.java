package br.com.abc.javacore.Zgenerics.teste;

import java.util.ArrayList;
import java.util.List;

/***
 * MÉTODOS ABSTRATOS
 */
public class MetodoGenericoTeste {
    public static void main(String[] args) {
        // Olhar la embaixo primeiro
        criarArrayVoid(new Cachorro("Spike"));
        List<Cachorro> doguinhos = criarArrayList(new Cachorro("Danny"));

    }
        // <T> = objeto envolvido
    public static <T> void criarArrayVoid(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
    }

    // Caso queiramos especificar o tipo de retorno
    // do metodo
    public static <T> List<T> criarArrayList(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
        return lista;
    }

    // E ainda é possível limitar
    public static <T extends Animal> List<T> criarArrayList(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
        return lista;
    }

}
