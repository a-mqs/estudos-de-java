package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

public class Seguradora {
    String nome;

    public Seguradora(String nome) {
        this.nome = nome;
    }

    public Seguradora() {
    }

    @Override
    public String toString() {
        return "Seguradora{" +
                "nome='" + nome + '\'' +
                '}';
    }

    // Para o caso do nome da seguradora poder vir nulo,
    // é adicionado ao construtor dela o Optional. Isso
    // faz com que desenvolvedores entendam que aquela
    // variável pode vir nula só de olhar o método
    public Optional<String> getNome() {
        return Optional.ofNullable(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
