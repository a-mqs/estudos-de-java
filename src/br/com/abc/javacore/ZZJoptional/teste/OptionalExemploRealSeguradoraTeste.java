package br.com.abc.javacore.ZZJoptional.teste;

import br.com.abc.javacore.ZZJoptional.classes2.Carro;
import br.com.abc.javacore.ZZJoptional.classes2.Pessoa;
import br.com.abc.javacore.ZZJoptional.classes2.Seguradora;

import java.util.Optional;

public class OptionalExemploRealSeguradoraTeste {
    public static void main(String[] args) {
        Seguradora segDevDojo = new Seguradora("Seguradora DevDojo");
        Carro carro = new Carro(segDevDojo, "BMW");
        Pessoa pessoa = new Pessoa("Marina", carro, 22);

        // Se você passar aqui uma pessoa, vai dar erro de
        // compilação
//        getNomeSeguradora(pessoa);

        // Porque a função pediu um Optional de Pessoa
        getNomeSeguradora(Optional.of(pessoa));

        // Mas por que pede um Optional de pessoa?
        // Para que não dê merda caso algo nulo seja passado:
        Pessoa pessoaNula = null;
        getNomeSeguradora(Optional.ofNullable(pessoaNula));

        // Dessa forma, se o nome da seguradora não puder ser
        // acessado por n motivos (como não ter pessoa, não
        // ter carro, não ter o próprio nome da seguradora,
        // a pessoa não ter carro, o carro não ter seguradora...),
        // o Optional fará a mensagem padrão aparecer.


    }

    public static String getNomeSeguradora(Optional<Pessoa> pessoa){
        System.out.println(pessoa
                // "É opcional: uma pessoa pode ou não ter um carro"
                .flatMap(Pessoa::getCarro)
                // "É opcional: um carro pode ou não ter uma seguradora"
                .flatMap(Carro::getSeguradora)
                // "Uma seguradora deve ter um nome"
                .map(Seguradora::getNome)
                .orElse("Não existe seguradora"));
        return "";
    }



}
