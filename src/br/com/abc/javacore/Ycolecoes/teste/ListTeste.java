package br.com.abc.javacore.Ycolecoes.teste;

import java.util.ArrayList;
import java.util.List;

/***
 * COLLECTIONS: LISTS
 */

public class ListTeste {
    public static void main(String[] args) {
        // ArrayList: um array que cresce
        // infinitamente de tamanho
        // O tipo entre as chaves impede que sejam adicionadas
        // coisas misturadas às listas
        // Não é possível usar tipos primitivos em coleções
        List<String> nomes = new ArrayList<>();
        List<String> nomes2 = new ArrayList<>();
        nomes.add("Amanda");
        nomes.add("devdojo");
        nomes2.add("Amanda2");
        nomes2.add("Devdojo2");
        nomes.addAll(nomes2);


        for (Object nome : nomes){
            System.out.println(nome);
        }

        nomes.add("Marques");
        for (Object nome : nomes){
            System.out.println(nome);
        }
        // isso vai fazer com que a lista compile novamente
        // adicionando mais um item

        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        for(Integer num : numeros){
            System.out.println(num);
        }

        /***
         * MÉTODOS INTERESSANTES:
         * (Usando a variável de referência dessa classe)
         * nomes.get(), o parâmetro é um int, pega um item da lista
         * nomes.remove(), os parâmetros são um int e um Object, serve para
         * remover coisas da lista:
         * nomes.size(), funciona da mesma forma que o .length de um array,
         * pra definir o tamanho dele
         * nomes.addAll(), o parâmetro é outra lista e adiciona
         * essa segunda ao nomes
         * nomes.clear(), para limpar o conteúdo da lista
         */

        nomes.remove(0); // Aqui ele apaga um item da lista
        nomes.remove("Amanda"); // Aqui ele retorna um boolean, true = apagado, false = não apagado


    }
}
