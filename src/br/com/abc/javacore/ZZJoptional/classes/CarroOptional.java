package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

public class CarroOptional {
    private Seguradora seguradoraOptional;
    private String nome;

    public CarroOptional(Seguradora seguradoraOptional, String nome) {
        this.seguradoraOptional = seguradoraOptional;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CarroOptional{" +
                "seguradoraOptional=" + seguradoraOptional +
                ", nome='" + nome + '\'' +
                '}';
    }

    // getSeguradora opcional(optional) porque nem sempre
    // um carro pode ter seguradoraOptional
    public Optional<Seguradora> getSeguradoraOptional() {
        return Optional.ofNullable(seguradoraOptional);
    }


    public void setSeguradoraOptional(Seguradora seguradoraOptional) {
        this.seguradoraOptional = seguradoraOptional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
