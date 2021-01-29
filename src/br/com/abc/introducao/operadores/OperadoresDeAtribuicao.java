package br.com.abc.introducao.operadores;

public class OperadoresDeAtribuicao {
    public static void main(String[] args) {

        /***
         * OPERADORES DE ATRIBUIÇÃO:
         * = ¬ igual
         * -= ¬ menos igual
         * += ¬ mais igual
         * *= ¬ vezes igual
         * /= ¬ divisão igual
         * %= ¬ resto igual
         *
         * Uso: para mudar um valor que uma variável ja possuía antes
         * desse ato
         */

        int salario = 1800;

        //Forma convencional
        //salario = salario + 1000;
        //Forma econômica
        salario += 1000;

        /***
         * EXTRA:
         * Cast ¬ mudar o tipo de uma variavel no meio do código
         *
         * Ex: salario + 10% do salario
         * salario = salario + (salario + 0.1) // na execução diria que a variável se transformaria em double
         * Como resolver:
         * salario = salario + (int) (salario + 0.1)
         * isso vai transformar o que é double em int
         *
         *
         */

        salario %= 2;

        System.out.println(salario);
    }

}

