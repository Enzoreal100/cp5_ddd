// RM: [Seu RM] - Nome: [Seu Nome]
package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.dto.Filme;

public class FilmeDAO {

    private Connection con;

    public FilmeDAO() {
        this.con = ConnectionFactory.abrirConexao();
    }

    public void inserir(Filme filme) {
        String sql = "INSERT INTO DDD_FILME (titulo, genero, produtora) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
    }

    public void alterar(Filme filme) {
        String sql = "UPDATE ddd_filme SET titulo = ?, genero = ?, produtora = ? WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.setInt(4, filme.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
    }

    public void excluir(Filme filme) {
        String sql = "DELETE FROM ddd_filme WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, filme.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
    }

    public ArrayList<Filme> listarTodos() {
        ArrayList<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM ddd_filme";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setCodigo(rs.getInt("codigo"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setProdutora(rs.getString("produtora"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        return filmes;
    }

    public void fecharConexao() {
        ConnectionFactory.fecharConexao(this.con);
    }
}
