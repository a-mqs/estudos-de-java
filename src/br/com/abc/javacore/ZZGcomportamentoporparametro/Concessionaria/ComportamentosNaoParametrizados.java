package br.com.abc.javacore.ZZGcomportamentoporparametro.Concessionaria;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classe.Carro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Arrays.asList;

public class ComportamentosNaoParametrizados {
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
        System.out.println(filtrarCarrosVerdes(carros));

        // Cliente: "Lindo. Agora faz uma lista de todos os carros
        // com menos de 10 anos"
        System.out.println(filtrarCarrosDezAnosRecentes(carros));

        // Cliente: "Okay, agora me dá uma lista de carros de cores
        // metálicas"
        System.out.println(filtrarCarrosMetalicos(carros));

        /**
         * Okay, agora vai de novo até os métodos
         */

}

    public static List<Carro> filtrarCarrosVerdes(List<Carro> carros){
        List<Carro>  carroList = new ArrayList<>();
        for (Carro carro : carros) {
            if(carro.getCor().equalsIgnoreCase("Verde")){
                carroList.add(carro);
            }
        }

        return carroList;
    }

    public static List<Carro> filtrarCarrosDezAnosRecentes(List<Carro> carros){
        List<Carro>  carroList = new ArrayList<>();
        for (Carro carro : carros) {
            if(carro.getAno() > Calendar.getInstance().get(Calendar.YEAR) - 10){
                carroList.add(carro);
            }
        }

        return carroList;
    }

    public static List<Carro> filtrarCarrosMetalicos(List<Carro> carros){
        List<Carro>  carroList = new ArrayList<>();
        for (Carro carro : carros) {
            /**
             * Reparou que no fim é tudo a mesma coisa e apenas
             * os ifs mudam?
             * Quando um método fica padronizado e apenas uma
             * condição se altera, nos podemos parametrizar esse
             * comportamento
             */
            if(carro.getCor().equalsIgnoreCase("Dourado") ||
                    carro.getCor().equalsIgnoreCase("Prata") ||
                    carro.getCor().equalsIgnoreCase("Bronze") ||
                    carro.getCor().equalsIgnoreCase("Cobre")){

                carroList.add(carro);
            }
        }

        return carroList;
    }








}
