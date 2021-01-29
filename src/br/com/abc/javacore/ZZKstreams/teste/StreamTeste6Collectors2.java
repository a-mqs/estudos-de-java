package br.com.abc.javacore.ZZKstreams.teste;

import br.com.abc.javacore.ZZKstreams.classes.Genero;
import br.com.abc.javacore.ZZKstreams.classes.Maioridade;
import br.com.abc.javacore.ZZKstreams.classes.Pessoa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * groupingBy(): AGRUPAMENTO DE STREAMS
 * Esse é o método que usa de Map para agrupar valores de
 * uma lista (values) em determinadas categorias (keys)
 */

public class StreamTeste6Collectors2 {
    public static void main(String[] args) {
        List<Pessoa> pessoas =  Pessoa.bancoDePessoas();

        // Criando um Map que associa generos a cada pessoa de um tipo de genero

        // No Java 7
        Map<Genero, List<Pessoa>> generoListMap = new HashMap<>();
        List<Pessoa> masculinos = new ArrayList<>();
        List<Pessoa> femininos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getGenero().equals(Genero.FEMININO)) {
                femininos.add(pessoa);
            } else {
                masculinos.add(pessoa);
            }
        }

        generoListMap.put(Genero.FEMININO, femininos);
        generoListMap.put(Genero.MASCULINO, masculinos);
        System.out.println(generoListMap);

        // Agora, no Java 8
        Map<Genero, List<Pessoa>> collectGenero = pessoas.stream().collect(groupingBy(Pessoa::getGenero));
        System.out.println(collectGenero);

        // TUDO DIMINUIU PRA UMA FUCKING LINHA!!!

        // O groupingBy() também permite que você categorize por keys que não
        // são atributos da classe em questão (Pessoa, nesse caso):
        Map<Maioridade, List<Pessoa>> collectMaioridade = pessoas.stream().collect(groupingBy(pessoa -> {
            if (pessoa.getIdade() < 18) {
                return Maioridade.MENOR;
            } else {
                return Maioridade.ADULTO;
            }
        }));
        System.out.println(collectMaioridade);

        // Além disso, um collect() aceita um groupingBy() dentro de outro, o que possibilita colocar uma
        // lista categorizada dentro de outra categoria
        Map<Genero, Map<Maioridade, List<Pessoa>>> generoMaioridadePessoas = pessoas.stream().collect(groupingBy(Pessoa::getGenero, groupingBy(pessoa -> {
            if (pessoa.getIdade() < 18) {
                return Maioridade.MENOR;
            } else {
                return Maioridade.ADULTO;
            }
        })));
        System.out.println(generoMaioridadePessoas);

        // Você também pode colocar um metodo Collectors dentro do groupingBy(), dependendo da necessidade
        // Aqui, por exemplo, mostra a contagem de cada elemento que cabe nas categorias
        Map<Genero, Long> contagemMap = pessoas.stream().collect(groupingBy(Pessoa::getGenero, counting()));
        System.out.println(contagemMap);

        // E aqui mostra o maior salario dentro de cada categoria
        Map<Genero, Optional<Pessoa>> generoOptionalMap = pessoas.stream().collect(groupingBy(Pessoa::getGenero, maxBy(Comparator.comparing(Pessoa::getSalario))));
        System.out.println(generoOptionalMap);

        // O exemplo anterior retorna um Optional, o que é inútil ao se lidar com Maps, visto que se a chave for nula, sequer
        // existirá valor. É possível tirar ele usando o collectingAndThen():
        Map<Genero, Pessoa> generoPessoaMap = pessoas.stream()
                .collect(groupingBy(Pessoa::getGenero,
                        // "Coleta o maior salario..."
                        collectingAndThen(maxBy(Comparator.comparing(Pessoa::getSalario)),
                        // "... e tira ele do Optional"
                        Optional::get)));
        System.out.println(generoPessoaMap);

        // Agrupando por gênero e estatistica
        Map<Genero, DoubleSummaryStatistics> collectGeneroEstatistica = pessoas.stream().collect(groupingBy(Pessoa::getGenero, summarizingDouble(Pessoa::getSalario)));
        System.out.println(collectGeneroEstatistica);

        // Mesma coisa que o anterior, mas com uso de Set
        Map<Genero, Set<Maioridade>> collectMappingSet = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(p -> {
            if (p.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }, toSet())));
        System.out.println(collectMappingSet);

        // Usando o mapping() é possivel exibir os objetos apenas por algum dos seus atributos, especificados no momento da implementação.
        // Nesse caso, estamos trazendo o gênero de cada um dos objetos e os colocando numa lista
        Map<Genero, List<Maioridade>> collectGeneroMaioridade = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(pessoa -> {
            if (pessoa.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }, toList())));

        System.out.println(collectGeneroMaioridade);

        // Mas caso você não queira informações repetidas, pode usar um Set
        Map<Genero, Set<Maioridade>> generoSetMap = pessoas.stream().collect(groupingBy(Pessoa::getGenero, mapping(pessoa -> {
            if (pessoa.getIdade() < 18) return Maioridade.MENOR;
            else return Maioridade.ADULTO;
        }, toSet())));

        System.out.println(generoSetMap);

    }
}