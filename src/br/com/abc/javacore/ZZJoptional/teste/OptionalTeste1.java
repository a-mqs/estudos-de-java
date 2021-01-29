package br.com.abc.javacore.ZZJoptional.teste;



import java.util.Optional;

/**
 * CLASSE OPTIONAL
 * Veio no java 8 para auxiliar contra NullPointerExceptions,
 * uma alternativa a encapsular codigos a varios if (variavel != null){}
 */

public class OptionalTeste1 {
    private String nomeNaoNulo = "Maria";
    private String nome;

    public static void main(String[] args) {
        OptionalTeste1 optionalTeste = new OptionalTeste1();

        // Encapsulando variavel em Optional caso o desenvolvedor tenha certeza
        // de que a variavel utilizada é não-nula (utilizar o método of())
        Optional<String> optionalCertezaNaoNulo = Optional.of(optionalTeste.nomeNaoNulo);

        // Também é possivel utilizar um Optional vazio
        Optional<String> optionalVazio = Optional.empty();

        // E também tem pro caso do desenvolvedor não saber se a variavel
        // utilizada é ou não nula. Se for, vai retornar Optional.empty();
        Optional<String> optionalIncerto = Optional.ofNullable(optionalTeste.nomeNaoNulo);


        System.out.println(optionalCertezaNaoNulo);
        System.out.println(optionalVazio);
        System.out.println(optionalIncerto);

        // Para retornar o valor de dentro do Optional é possível utilizar o get()
        System.out.println(optionalCertezaNaoNulo.get());

        // Contudo, se o optional tiver vazio, o compilador vai retornar uma NoSuchElementException,
        // o que torna necessário confirmar se o optional em questão está vazio ou não usando um if e
        // isPresent()
        if(optionalIncerto.isPresent()){
            System.out.println(optionalIncerto.get());
        }

        // Mas estamos usando Optionals para evitar Exceptions e ifs, não é? Isso mostra que a
        // solução anterior é real contraditória.
        // É melhor usar o método orElse(), que retorna alguma coisa por padrão dada pelo dev
        // caso o Optional esteja vazio
        System.out.println(optionalVazio.orElse("Ta vazio fi"));


    }
}
