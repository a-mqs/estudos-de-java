package br.com.abc.javacore.ZZHlambdas.teste;

import java.util.concurrent.Callable;

/**
 * LAMBDAS
 *
 * Lambdas foram introduzidos no Java 8 com a intenção
 * de tornar melhor o visual dos códigos que precisavam implementar
 * classes anônimas para preencher métodos de interfaces.
 *
 * Ao invés de criar um novo objeto da interface e abrir as chaves
 * no meio do código, as lambdas reduzem isso tudo numa linha:
 *
 * (parametros) -> {expressão};
 *
 * A forma da lambda varia conforme o método que ela está
 * mostrando simplificadamente. Uns tem parâmetros, outros não.
 * Uns tem uma linha de codigo, outros tem várias (quando tem, devem
 * ficar dentro de chaves na lambda). Vai depender do contexto e
 * da interface implementada.
 *
 * Além disso, métodos de interfaces só podem ser transformados
 * em lâmbdas se a interface for funcional. Interfaces funcionais
 * contam com apenas um método ou com vários métodos default, exceto um.
 *
 */

public class LambdaInnerClassesComparar {
    public static void main(String[] args) {
        /**
         * Vamos usar threads para facilitar o entendimento
         */

        // Ao invés de escrever:
        Runnable runnableSoma = new Runnable() {
            @Override
            public void run() {
                System.out.println(5 + 5);
            }
        };

        // Podemos escrever:
        Runnable runnableSomaLambda = () -> System.out.println(5 + 5);

        /**
         * Repare no exemplo anterior:
         * SEMPRE precisamos ter a referencia do método da interface
         * para transformar em lambda. Nesse caso, o método run().
         * O run() não tem parâmetros, então também não foram
         * adicionados a lambda.
         * Os parametros foram separados da expressão com ->
         * E após, colocamos o que queremos dentro daquele método,
         * nesse caso, imprimir 5 + 5
         */

        // Comparando
        Thread t1 = new Thread(runnableSoma);
        Thread t2 = new Thread(runnableSomaLambda);
        t1.start();
        t2.start();

        /**
         * Agora um exemplo com mais de uma linha de código
         * dentro do método da interface/lambda:
         */

        // Ao invés de escrever:
        Runnable runnableFruta = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Mamão é muito bom");
                    Thread.sleep(3000);
                    System.out.println("Mentira");
                    System.out.println("Melancia é melhor");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Podemos escrever:
        Runnable runnableFrutaLambda = () -> {
            try {
                System.out.println("Mamão é muito bom");
                Thread.sleep(3000);
                System.out.println("Mentira");
                System.out.println("Morango é melhor");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        // Comparando
        Thread t3 = new Thread(runnableFruta);
        Thread t4 = new Thread(runnableFrutaLambda);
        t3.start();
        t4.start();



    }
}
