package br.com.abc.introducao.controlefluxo;

public class ControleDeFluxo5 {
    public static void main(String[] args) {

        /***
         * Dado o valor de um carro, descobrir quantas vezes ele pode
         * ser parcelado, as parcelas não podem ser menores que
         * 1000 reais
         */

        double valorCarro = 30000;

        /* A intenção aqui é calcular o valor a ser pago em 1 parcela,
        * 2 parcelas...
        * Pra isso, a lógica é a seguinte
        * Enquanto a parcela for menor ou igual ao valor do carro,
        * o código vai calcular o valor da parcela dividindo o valor
        * do carro pelo numeros de parcelas e depois vai incrementar
        * a parcela
        * */
        for (int parcela = 1; parcela <= valorCarro; parcela++) {
            double valorParcela = valorCarro / parcela;
            if (valorParcela < 1000) {
                //"Se for menor que 1000, saia do código sem fazer nada"
                break;
            } else {
                //"Se for maior que 1000, faça isso"
                System.out.println("Parcela: " + parcela + " R$" + valorParcela);

            }

            /***
             * LEMBRANDO:
             * exercicio apenas para mostrar que é possível
             * utilizar break
             * USAR BREAK SEM SWITCH VAI CONTRA AS BOAS PRÁTICAS
             * DA PROGRAMAÇÃO
             */
        }
    }
}
