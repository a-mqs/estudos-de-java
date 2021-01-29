package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

public class PizzaFactory {
    public static Pizza getPizza(String tamanhoPizza){
        if (tamanhoPizza.equalsIgnoreCase("Pequena")){
            // Interessante: O return só pode ser colocado
            // no fim do método, contudo, se ele precisar
            // ser decidido por um if, pode ter mais returns
            // ao longo do metodo
            return new Pequena();
        } else if (tamanhoPizza.equalsIgnoreCase("Media")) {
            return new Media();
        } else if (tamanhoPizza.equalsIgnoreCase("Grande")){
            return new Grande();
        } else return null;
    }
}
