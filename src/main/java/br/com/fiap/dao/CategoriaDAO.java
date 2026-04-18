package br.com.fiap.dao;

import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoriaDAO {
    private Connection conexao;

    public CategoriaDAO() throws SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void insert(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO t_fin_categoria (id, nome, tipo, data_criacao, data_edicao) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, categoria.getId().toString());
        stm.setString(2, categoria.getNome());
        stm.setString(3, categoria.getTipo());
        stm.setTimestamp(4, java.sql.Timestamp.valueOf(categoria.getDataCriacao()));
        stm.setTimestamp(5, java.sql.Timestamp.valueOf(categoria.getDataEdicao()));
        stm.executeUpdate();
    }

    public Categoria search(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "SELECT id, nome, tipo, data_criacao, data_edicao FROM t_fin_categoria WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new EntityNotFoundException("Categoria não encontrada.");
        }

        return mapResultSetToCategoria(result);
    }

    public List<Categoria> getAll() throws SQLException {
        String sql = "SELECT id, nome, tipo, data_criacao, data_edicao FROM t_fin_categoria ORDER BY id";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Categoria> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(mapResultSetToCategoria(result));
        }

        return lista;
    }

    public void update(Categoria categoria) throws SQLException {
        categoria.setDataEdicao(java.time.LocalDateTime.now());
        String sql = "UPDATE t_fin_categoria SET nome = ?, tipo = ?, data_edicao = ? WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, categoria.getNome());
        stm.setString(2, categoria.getTipo());
        stm.setTimestamp(3, java.sql.Timestamp.valueOf(categoria.getDataEdicao()));
        stm.setString(4, categoria.getId().toString());
        stm.executeUpdate();
    }

    public void delete(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "DELETE FROM t_fin_categoria WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());

        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException("Categoria não encontrada para ser removida");
        }
    }

    private Categoria mapResultSetToCategoria(ResultSet result) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(UUID.fromString(result.getString("id")));
        categoria.setNome(result.getString("nome"));
        categoria.setTipo(result.getString("tipo"));
        return categoria;
    }

    public void closeConnection() throws SQLException {
        conexao.close();
    }
}