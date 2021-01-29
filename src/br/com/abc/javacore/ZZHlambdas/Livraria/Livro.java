package br.com.abc.javacore.ZZHlambdas.Livraria;

public class Livro {
    private String nome;
    private int ano;
    private String genero;
    private String autor;

    public Livro(String nome, int ano, String genero, String autor) {
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.autor = autor;
    }

    public Livro() {
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", ano=" + ano +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
