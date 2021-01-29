package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import javax.swing.*;

public class PizzaFactoryTeste {
    public static void main(String[] args) {
        String tamanho = JOptionPane.showInputDialog("Tamanho da pizza:");

        Pizza pizzaPreco = PizzaFactory.getPizza(tamanho);

        System.out.println(pizzaPreco);
    }

}
