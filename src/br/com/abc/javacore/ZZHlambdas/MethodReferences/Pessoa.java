package br.com.abc.javacore.ZZHlambdas.MethodReferences;

public class Pessoa {
    protected String nome;
    protected String sobrenome;
    protected int idade;

    public Pessoa(String nome, String sobrenome, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                '}';
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    // Métodos de ação
    public static void apresentacaoStatic(Pessoa pessoa) {
        System.out.println("Olá, eu sou " + pessoa.getNome());
        System.out.println("Mas sou static tbm sz");
    }

    public void apresentacaoNormalParametro(Pessoa pessoa) {
        System.out.println("Olá, eu sou " + pessoa.getNome());
    }

    public void apresentacaoNormal() {
        System.out.println("Olá, eu sou " + getNome());
    }


}