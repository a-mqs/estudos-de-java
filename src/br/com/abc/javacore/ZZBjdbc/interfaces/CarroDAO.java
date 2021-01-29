package br.com.abc.javacore.ZZBjdbc.interfaces;

import br.com.abc.javacore.ZZBjdbc.classe.Carro;
import br.com.abc.javacore.ZZBjdbc.classe.Comprador;

import java.util.List;

/**
 * PADRÃO DAO
 * Quando você está criando classes baseadas no pacote
 * sql do Java para lidar com bancos de dado, você cria
 * vários métodos que executam comandos do SQL no Java.
 * Até agora chamamos a classe com esse compilado de
 * métodos de ClasseDAO
 *
 * Mas isso não condiz com as boas práticas de programação.
 *
 * O que condiz é ter uma interface com o máximo de métodos de
 * comandos SQL possivel e essa interface deve ser implementada
 * em uma classe, para que os métodos sejam melhores adaptados a
 * cada situação.
 *
 * Nesse caso fizemos um DAO específico pra Carro, mas existem
 * também (e dá pra fazer na mão) DAOs genéricos;
 */

public interface CarroDAO {
    void save(Carro carro, Comprador comprador);

    List<Carro> selectAll();

    void update(Carro carro);

    List<Carro> searchByName(String pedacoNome);

    void delete(Carro carro);

}
