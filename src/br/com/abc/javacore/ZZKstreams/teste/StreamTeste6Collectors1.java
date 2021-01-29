package br.com.abc.javacore.ZZKstreams.teste;

import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * FRAMEWORK Collectors
 * O objetivo desse framework é diminuir a quantidade
 * de linhas de código para executar uma ação
 */

public class StreamTeste6Collectors1 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        // para contar o numero de pessoas
        System.out.println(pessoas.stream().count());
        // para contar o numero de pessoas usando o Collectors
        System.out.println(pessoas.stream().collect(Collectors.counting()));

        // Do modo normal
        Optional<Pessoa> max = pessoas.stream().max(comparing(Pessoa::getSalario));
        System.out.println(max.get().getSalario());
        // Com Collectors (mas chamando a forma estatica dos métodos dessa vez)
        Optional<Pessoa> collect = pessoas.stream().collect(maxBy(comparing(Pessoa::getSalario)));
        System.out.println(collect.get().getSalario());
        Optional<Pessoa> collect1 = pessoas.stream().collect(minBy(comparing(Pessoa::getSalario)));
        System.out.println(collect1.get().getSalario());



        // Somando com tipos primitivos
        System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).sum());
        // Agora usando Collect
        System.out.println(pessoas.stream().collect(summingDouble(Pessoa::getSalario)));

        // Tirando a media com tipo primitivo (retorna um Optional)
        System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).average());
        // Agora com collect
        System.out.println(pessoas.stream().collect(averagingDouble(Pessoa::getSalario)));

        // Classe DoubleSumaryStatistics: foi feita para sumarizar, ou seja, traz todas as
        // operações anteriores dentro do framework Collectors
        DoubleSummaryStatistics collect2 = pessoas.stream().collect(summarizingDouble(Pessoa::getSalario));
        System.out.println(collect2);
        // Para chamar algum valor especifico, só chama-lo com getValorEspecifico()
        System.out.println(collect2.getCount());


        // E para concatenar Strings: joining()
        System.out.println(pessoas.stream().map(Pessoa::getNome).collect(joining()));
        // joining() com delimitador entre os itens
        System.out.println(pessoas.stream().map(Pessoa::getNome).collect(joining(", ")));


    }
}
