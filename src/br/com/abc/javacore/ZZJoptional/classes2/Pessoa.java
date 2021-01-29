package br.com.abc.javacore.ZZJoptional.classes2;

import java.util.Optional;

public class Pessoa {
    private String nome;
    private Carro carro;
    private int idade;

    public Pessoa(String nome, Carro carro, int idade) {
        this.nome = nome;
        this.carro = carro;
        this.idade = idade;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Uma pessoa nem sempre vai ter um carro,
    // portanto, o retorno deve ser Optional
    public Optional<Carro> getCarro() {
        return Optional.ofNullable(carro);
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
