package br.com.abc.javacore.ZZAclassesinternas.teste;

public class Frutas {
    public static void main(String[] args) {
        Frutas fruta = new Frutas();
        Banana banana = fruta.new Banana();

        System.out.println(banana.getNome());

        Maçã maçã = fruta.new Maçã();

        System.out.println(maçã.getNome());

    }

    class Banana{
        String nome = "Banana";

        public String getNome(){
            return nome;
        }
    }

    class Maçã{
        String nome = "Maçã";

        public String getNome(){
            return nome;
        }
    }


}
