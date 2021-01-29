package br.com.abc.javacore.ZZGcomportamentoporparametro.Concessionaria;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ComportamentoParametrizados {
    public static void main(String[] args) {
        Carro vermelho = new Carro("Vermelho", 1952);
        Carro azul = new Carro("Azul", 2018);
        Carro cinza = new Carro("Cinza", 2016);
        Carro branco = new Carro("Branco", 2019);
        Carro prata = new Carro("Prata", 2014);
        Carro verde = new Carro("Verde", 2015);
        Carro verde2 = new Carro("Verde", 2010);
        Carro verde3 = new Carro("Verde", 2001);
        Carro dourado = new Carro("Dourado", 2000);
        Carro cobre = new Carro("Cobre", 1974);
        Carro preto = new Carro("Preto", 1950);
        Carro vinho = new Carro("Vinho", 1966);
        Carro laranja = new Carro("Laranja", 1984);

        List<Carro> carros = asList(vermelho, azul, cinza, branco, prata, verde,
                dourado, cobre, preto, vinho, laranja, verde2, verde3);


        // Cliente: "Eu quero que vc retorne pra mim todos os
        // carros verdes"
        /**
         * É só chamar o método filtrarCarros e na hora
         * que pede o CarroPredicate, criar um objeto
         * do CarroPredicate especifico <3
         */
        System.out.println(filtrarCarros(carros, new CarrosVerdesPredicate()));

        // Cliente: "Lindo. Agora faz uma lista de todos os carros
        // com menos de 10 anos"
        System.out.println(filtrarCarros(carros, new CarrosDezAnosRecentesPredicate()));

        // Cliente: "Okay, agora me dá uma lista de carros de cores
        // metálicas"
        System.out.println(filtrarCarros(carros, new CarrosMetalicosPredicate()));

        /**
         * Okay, agora vai de novo até os métodos
         */

    }

    public static List<Carro> filtrarCarros(List<Carro> carros, CarroPredicate carroPredicate){
        List<Carro>  carroList = new ArrayList<>();
        for (Carro carro : carros) {
            /**
             * Agora temos um único método para filtrar os carros.
             *
             * O que fizemos aqui?
             *
             * 1- Generalização: a gente tornou o comportamento
             * padrão uma interface. Ou seja, o que constantemente
             * fazíamos era comparar um carro específico com alguma
             * condição (se era verde, novo, metálico, enfim...). Nós
             * generalizamos isso criando um método que compare coisas
             * e receba um carro como argumento, colocando na interface
             * CarroPredicate um método boolean que tem um parâmetro do
             * tipo Carro.
             *
             * 2- Especificação: Tendo esse método genérico, agora
             * ele deve ser extendido para cada situação especifica.
             * Como fazer isso? Bem, devem ser criadas classes que
             * implementem a interface onde está o metodo genérico
             * (CarroPredicate, nesse caso), e ao implementar a interface,
             * deve-se colocar a comparação que você quer no
             * retorno. Fizemos isso na classe
             * CarrosMetálicosPredicate, por exemplo. Extendemos o
             * método padrão compare() e no retorno colocamos a
             * condição especifica, a de retornar true quando
             * os carros passados fossem de cores metálicas.
             * Em CarrosVerdesPredicates, a condição para true
             * é que a cor do carro passado fosse verde. E assim
             * por diante.
             *
             * 3- Aplicação: dessa forma, você pode fazer milhares
             * de classes que extendam CarroPredicate e que comparem
             * alguma coisa entre os carros recebidos. A aplicação
             * está logo abaixo. Nesse método, temos um CarroPredicate
             * como parâmetro, um comparador. Assim, quando chegarmos
             * ao if, o que precisaremos fazer é apenas chamar o objeto
             * do CarroPredicate daquele momento e puxar o método
             * compare(), passando o carro específico do contexto
             * como argumento.
             */
            if(carroPredicate.compare(carro)){
                carroList.add(carro);
            }
        }

        return carroList;
    }


}
