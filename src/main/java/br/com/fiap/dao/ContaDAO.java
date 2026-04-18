package br.com.fiap.dao;

import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContaDAO {
    private Connection conexao;

    public ContaDAO() throws SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void insert(Conta conta) throws SQLException {
        String sql = "INSERT INTO t_fin_conta (id, nome, status, data_criacao, data_edicao, saldo_atual) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, conta.getId().toString());
        stm.setString(2, conta.getNome());
        stm.setString(3, conta.getStatus() ? "T" : "F");
        stm.setTimestamp(4, java.sql.Timestamp.valueOf(conta.getDataCriacao()));
        stm.setTimestamp(5, java.sql.Timestamp.valueOf(conta.getDataEdicao()));
        stm.setDouble(6, 0);
        stm.executeUpdate();
    }

    public Conta search(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "SELECT id, nome, status, data_criacao, data_edicao, saldo_atual FROM t_fin_conta WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new EntityNotFoundException("Conta não encontrada.");
        }

        return mapResultSetToConta(result);
    }

    public List<Conta> getAll() throws SQLException {
        String sql = "SELECT id, nome, status, data_criacao, data_edicao, saldo_atual FROM t_fin_conta ORDER BY id";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Conta> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(mapResultSetToConta(result));
        }

        return lista;
    }

    public void update(Conta conta) throws SQLException {
        conta.setDataEdicao(java.time.LocalDateTime.now());
        String sql = "UPDATE t_fin_conta SET nome = ?, status = ?, data_edicao = ?, saldo_atual = ? WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, conta.getNome());
        stm.setString(2, conta.getStatus() ? "T" : "F");
        stm.setTimestamp(3, java.sql.Timestamp.valueOf(conta.getDataEdicao()));
        stm.setDouble(4, 0.0); // saldo_atual - valor padrão
        stm.setString(5, conta.getId().toString());
        stm.executeUpdate();
    }

    public void delete(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "DELETE FROM t_fin_conta WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());

        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException("Conta não encontrada para ser removida");
        }
    }

    private Conta mapResultSetToConta(ResultSet result) throws SQLException {
        Conta conta = new Conta();
        conta.setId(UUID.fromString(result.getString("id")));
        conta.setNome(result.getString("nome"));
        conta.setStatus(result.getString("status").equals("T"));
        return conta;
    }

    public void closeConnection() throws SQLException {
        conexao.close();
    }
}