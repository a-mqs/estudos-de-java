package br.com.abc.javacore.Ycolecoes.teste;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/***
 * INTERFACE NAVIGABLEMAP
 */

public class TreeMapTeste {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "Letra A");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("D", "Letra D");
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        /***
         * MÉTODOS ÚTEIS:
         * headMap(): Retorna um map com as chaves menores
         * do que a referencia colocada. Pede um valor boolean
         * em seguida - (true = inclua a chave na exibição ,
         * false = mostre tudo acima da chave)
         *
         * pollFirstEntry e pollLastEntry: funcionam da mesma forma
         * que no Set, retornando e excluindo o primeiro e o último item
         *
         * ceiling e higher também funcionam da mesma forma,
         * retornando o posterior e o anterior
         *
         * descendendingMap(); inverte a ordem do map
         */
        // headMap():
        System.out.println(map.headMap("C", true));
        // higher();
        System.out.println(map.higherEntry("C"));
        // descendendingMap()
        System.out.println(map.descendingMap());
    }
}
