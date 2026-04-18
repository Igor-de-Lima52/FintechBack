package br.com.fiap.dao;

import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BancoDAO {
    private Connection conexao;

    public BancoDAO() throws SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void insert(Banco banco) throws SQLException {
        String sql = "INSERT INTO t_fin_banco (id, nome, status, data_criacao, data_edicao) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, banco.getId().toString());
        stm.setString(2, banco.getNome());
        stm.setString(3, banco.getStatus() ? "T" : "F");
        stm.setTimestamp(4, java.sql.Timestamp.valueOf(banco.getDataCriacao()));
        stm.setTimestamp(5, java.sql.Timestamp.valueOf(banco.getDataEdicao()));
        stm.executeUpdate();
    }

    public Banco search(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "SELECT id, nome, status, data_criacao, data_edicao FROM t_fin_banco WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new EntityNotFoundException("Banco não encontrado.");
        }

        return mapResultSetToBanco(result);
    }

    public List<Banco> getAll() throws SQLException {
        String sql = "SELECT id, nome, status, data_criacao, data_edicao FROM t_fin_banco ORDER BY id";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Banco> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(mapResultSetToBanco(result));
        }

        return lista;
    }

    public void update(Banco banco) throws SQLException {
        banco.setDataEdicao(java.time.LocalDateTime.now());
        String sql = "UPDATE t_fin_banco SET nome = ?, status = ?, data_edicao = ? WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, banco.getNome());
        stm.setString(2, banco.getStatus() ? "T" : "F");
        stm.setTimestamp(3, java.sql.Timestamp.valueOf(banco.getDataEdicao()));
        stm.setString(4, banco.getId().toString());
        stm.executeUpdate();
    }

    public void delete(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "DELETE FROM t_fin_banco WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());

        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException("Banco não encontrado para ser removido");
        }
    }

    private Banco mapResultSetToBanco(ResultSet result) throws SQLException {
        Banco banco = new Banco();
        banco.setId(UUID.fromString(result.getString("id")));
        banco.setNome(result.getString("nome"));
        banco.setStatus(result.getString("status").equals("T"));
        return banco;
    }

    public void closeConnection() throws SQLException {
        conexao.close();
    }
}