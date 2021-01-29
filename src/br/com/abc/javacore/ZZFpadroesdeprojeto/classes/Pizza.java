package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

/**
 * PADRÃO FACTORY
 * Esse é um padrão que cria objetos de subclasses
 * apenas no momento em que essas subclasses precisam
 * ser usadas, o que pode variar conforme o contexto.
 * Num momento você pode precisar de uma classe, já em
 * outro, de outra classe.
 */

/**
 * Lembrando: classes abstratas foram feitas para
 * ser extendidas, não usadas
 */
public abstract class Pizza {
    protected float valor;

    @Override
    public String toString() {
        return "Pizza{" +
                "valor=" + valor +
                '}';
    }

    public float getPreco(){
        return valor;
    }
}

class Pequena extends Pizza {
    public Pequena(){
        valor = 15.0f;
    }
}

class Media extends Pizza {
    public Media(){
        valor = 20.0f;
    }
}

class Grande extends Pizza {
    public Grande(){
        valor = 25.0f;
    }
}














