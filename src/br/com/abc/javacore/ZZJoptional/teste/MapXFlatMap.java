package br.com.abc.javacore.ZZJoptional.teste;

import br.com.abc.javacore.ZZJoptional.classes.Celular;

import java.util.Optional;

public class MapXFlatMap {
    public static void main(String[] args) {
        Celular cXiaomi = new Celular("96523-1258");
        Celular cSamsung = new Celular("92369-8521");

        cXiaomi.setNome("Xiaomi Mi 7");

        // Um Optional nada mais é que um "pode ser que tenha o
        // que você quer aqui dentro ou não". Se tiver, vai vir
        // encapsulado dentro de um Optional
        // Ex: Optional[coisa]
        System.out.println(Optional.ofNullable(cXiaomi).map(Celular::getNome));

        // Se não tiver a coisa que você procura, o Optional vai retornar vazio
        // Ex: Optional.empty
        System.out.println(Optional.ofNullable(cSamsung).map(Celular::getNome));


        // Mas repare nesse caso. Estamos usando map numa variável que retorna um
        // Optional, o que nos fará ter um Optional de uma variável que já era
        // Optional
        System.out.println(Optional.ofNullable(cXiaomi).map(Celular::getNomeOptional));
        System.out.println(Optional.ofNullable(cSamsung).map(Celular::getNomeOptional));

        // Para contornar isso e retornar o que tá dentro do Optional coberto nós
        // usamos o flatMap(), um map que pega um tipo de entrada e retorna um
        // Optional<tipo da saída>. Isso poissíbilita que o valor de dentro do
        // Optional coberto seja obtido puramente
        System.out.println(Optional.ofNullable(cXiaomi).flatMap(Celular::getNomeOptional));

        // Beleza, agora o Optional que estava dentro do outro Optional foi eliminado
        // E para obter o valor de dentro do Optional que sobrou, só usar o orElse()
        System.out.println(Optional.ofNullable(cXiaomi).flatMap(Celular::getNomeOptional).orElse("Optional vazio, irmao"));



    }




}
