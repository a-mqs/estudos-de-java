package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

public class Celular {
    private String numero;
    private String nome;

    public Celular(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    // Quando um get é feito com o optional,
    // é como se ele dissesse para o dev que
    // está lendo o código que a variável
    // aqui lidada pode ser nula ou não
    public Optional<String> getNomeOptional() {
        return Optional.ofNullable(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
