package br.com.abc.javacore.ZZBjdbc.database;

import br.com.abc.javacore.ZZBjdbc.ConexaoFactory;
import br.com.abc.javacore.ZZBjdbc.classe.Carro;
import br.com.abc.javacore.ZZBjdbc.classe.Comprador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarroDAOClasse {

    public static void save(Carro carro, Comprador comprador) {
        String sql = "INSERT INTO agencia.carro (placa, nome, compradorId) VALUES (?, ?, ?);";
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getNome());
            ps.setInt(3, comprador.getId());

            System.out.println(carro);

            System.out.print("Deseja mesmo adicionar esse carro a lista? (S/N): ");
            String opcao = new Scanner(System.in).nextLine();
            if (opcao.equalsIgnoreCase("s")) {
                ps.executeUpdate();
                System.out.println("Carro adicionado com sucesso");
            } else if (opcao.equalsIgnoreCase("n")) {
                System.out.println("O carro não foi adicionado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Carro> selectAll() {
        String sql = "SELECT * FROM agencia.carro;";
        List<Carro> carroList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Comprador comprador = CompradorDAO.searchById(rs.getInt("compradorId"));
                carroList.add(new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("nome"), comprador));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carroList;
    }

    public static void update(Carro carro) {
        String sql = "UPDATE agencia.carro SET placa = ?, nome = ? WHERE id = ?";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getNome());
            ps.setInt(3, carro.getId());

            System.out.println(carro);

            System.out.print("Essas foram as mudanças. Deseja atualizar o banco? (S/N): ");
            String opcao = new Scanner(System.in).nextLine();
            if (opcao.equalsIgnoreCase("s")) {
                ps.executeUpdate();
                System.out.println("Carro atualizado com sucesso!");
            } else if (opcao.equalsIgnoreCase("n")) {
                System.out.println("O carro não foi atualizado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Carro> searchByName(String pedacoNome) {
        String sql = "SELECT * FROM agencia.carro WHERE nome LIKE ?;";

        List<Carro> carroList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + pedacoNome + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comprador comprador = CompradorDAO.searchById(rs.getInt("compradorId"));
                carroList.add(new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("nome"), comprador));
            }

            ConexaoFactory.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carroList;
    }

    public static void delete(Carro carro) {
        String sql = "DELETE FROM agencia.carro WHERE id = ?";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, carro.getId());
            ps.executeUpdate();

            System.out.println(carro);

            System.out.print("Deseja mesmo excluir esse carro a lista? (S/N): ");
            String opcao = new Scanner(System.in).nextLine();
            if (opcao.equalsIgnoreCase("s")) {
                ps.executeUpdate();
                System.out.println("Carro excluido com sucesso");
            } else if (opcao.equalsIgnoreCase("n")) {
                System.out.println("O carro não foi excluido");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





