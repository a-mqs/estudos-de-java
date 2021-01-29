package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

/**
 * PADRÃO SINGLETON
 * Usado quando o desenvolvedor tem parâmetros em que os
 * argumentos não podem se repetir
 * PORÉEEEEM
 * essa forma de se fazer o padrão não é recomendada, pois não tem proteção
 * contra construtores criados no método de teste
 * É muito mais indicado utilizar o exemplo em AviaoSingletonEnum
 */

public class AviaoSingleton {
    /**
     * EAGER INITIALIZATION: transformar o objeto a ser criado num objeto imutável
     * e alocá-lo na memória
     */

//    private static final AviaoSingleton INSTANCE = new AviaoSingleton();

    private static AviaoSingleton INSTANCE;
    private Set<String> assentosDisponiveis;

    /**
     * LAZY INITIALIZATION: criando um novo objeto apenas se for necessário
     * nesse caso a instancia não pode ser final nesse caso
     * Também pode ser ThreadSafe, usando synchronized e
     * perguntando novamente se a instancia é nula, pra confirmar
     */
    public static AviaoSingleton getINSTANCE() {
        // "Se não tiver nada dentro dessa variável INSTANCE..."
        if (INSTANCE == null){
            // "... então obtenha o lock dessa classe, pra apenas
            // uma thread trabalhar nela..."
            synchronized (AviaoSingleton.class){
                // "... e checa de novo: se for mesmo nulo..."
                if (INSTANCE == null){
                    // "... Então coloca um objeto AviaoSingleton dentro dela"
                    INSTANCE = new AviaoSingleton();
                }
            }

        }
        return INSTANCE;
    }

    /**
     * Construtor, com os assentos disponíveis
     */
    public AviaoSingleton(){
        this.assentosDisponiveis = new HashSet<>();
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public boolean escolherAssento(String assento){
        return assentosDisponiveis.remove(assento);
    }
}
