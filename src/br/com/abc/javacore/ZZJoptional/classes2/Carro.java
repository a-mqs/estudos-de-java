package br.com.abc.javacore.ZZJoptional.classes2;

import java.util.Optional;

public class Carro {
    private Seguradora seguradora;
    private String nome;

    public Carro(Seguradora seguradora, String nome) {
        this.seguradora = seguradora;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "seguradora=" + seguradora +
                ", nome='" + nome + '\'' +
                '}';
    }

    // Um carro nem sempre vai ter uma seguradora,
    // portanto, o retorno deve ser Optional
    public Optional<Seguradora> getSeguradora() {
        return Optional.ofNullable(seguradora);
    }


    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
