package br.com.abc.introducao.controlefluxo;

public class ControleDeFluxo6 {
    public static void main(String[] args) {

        //Seguindo a logica inversa do exercicio anterior

        double valorTotal = 30000;

        for (int parcela = (int) valorTotal; parcela >= 1; parcela--){
            double valorParcela = valorTotal / parcela;
            if (valorParcela <= 1000){
                /*
                continue:
                Se o que tá dentro do parênteses for true,
                SEGUE O BAILE, volta e tenta de novo
                 */
                continue;
            }

            System.out.println("Parcela " + parcela + " R$" + valorParcela);
        }
    }
}
