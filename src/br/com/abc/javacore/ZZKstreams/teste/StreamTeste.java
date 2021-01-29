package br.com.abc.javacore.ZZKstreams.teste;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * STREAMS:
 * Trabalha com coleções de forma muito mais simples, é uma atualização
 * vinda com Java 8 que diminui a verbosidade do código.

 * DIFERENÇA ENTRE STREAMS E COLLECTIONS
 * As Streams não são as Collections. Enquanto as Collections armazenam
 * os dados, os Streams servem para fazer operações com esses dados,
 * computá-los
 */

public class StreamTeste {
    /**
     * Missão: pegar os 3 primeiros nomes das pessoa com menos de 25 anos
     * ordenados pelo nome
     */

    /**
     * Resolução no Java 7
     */
    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        Collections.sort(pessoas, (o1, o2) -> o1.getNome().compareToIgnoreCase(o2.getNome()));
        List<String> nomesMenorQue25Java7 = new ArrayList<>();
        for (Pessoa pessoaItem : pessoas){
            if (pessoaItem.getIdade() < 25){
                nomesMenorQue25Java7.add(pessoaItem.getNome());
                if (nomesMenorQue25Java7.size() >= 3){
                    break;
                }
            }
        }
        System.out.println(nomesMenorQue25Java7);

        System.out.println("---------------------------------------------------");


        /**
         * A partir do Java 8:
         */
        List<String> nomesMenorQue25Java8 = pessoas
                // stream(): pega as informações em tempo real
                .stream()
                // filter(): para filtrar os resultados
                .filter(pessoa -> pessoa.getIdade() < 25)
                // sorted(): para implementar o comparator, dentro do método comparing
                .sorted(Comparator.comparing(Pessoa::getNome))
                // limit(): limita a quantidade de itens
                .limit(3)
                // map(): é um Function, pega um tipo de valor e transformar em outro tipo de valor
                // vai pegar os valores de getNome() e transformar em Strings...
                .map(Pessoa::getNome)
                // ... e jogar tudo pra dentro de uma lista como collect()
                .collect(Collectors.toList());

        /**
         * MÉTODOS INTERMEDIATE E TERMINAL
         *
         * São chamados de métodos intermediate os métodos
         * que continuam retornando valores em stream e
         * possibilitam que o dev faça mais operações streams
         * em cima daquela lista.
         *
         * Se o método retorna algo diferente de uma stream,
         * esse método é um terminal, que finda a possibilidade
         * de fazer operações stream.
         */

        System.out.println(nomesMenorQue25Java8);

        /**
         * Mais dois metodos uteis
         */
        System.out.println(pessoas
                .stream()
                // distinct(): mostra quantos elementos distintos tem na lista
//                .distinct()
                .filter(pessoa -> pessoa.getIdade() < 25)
                .sorted(Comparator.comparing(Pessoa::getNome))
                .limit(3)
                // skip(): pula o resultado selecionado dentro dos parenteses, de acordo com a ordenação
                .skip(1)
                .map(Pessoa::getNome)
                // count(): conta quantos elementos correspondentes a todas as condições
                // acima há na lista
                .count()
        );

        // E ainda tem um for
        pessoas.stream().forEach(System.out::println);

    }


}
