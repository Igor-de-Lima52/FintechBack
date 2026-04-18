package br.com.fiap.dao;

import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Investimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InvestimentoDAO {
    private Connection conexao;

    public InvestimentoDAO() throws SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void insert(Investimento investimento) throws SQLException {
        String sql = "INSERT INTO t_fin_investimento (id, nome, tipo, saldo_atual, descricao, data_criacao, data_edicao, id_usuario, id_categoria, id_conta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, investimento.getId().toString());
        stm.setString(2, investimento.getNome());
        stm.setString(3, investimento.getClass().getSimpleName());
        stm.setDouble(4, investimento.getValor());
        stm.setString(5, investimento.getDescricao());
        stm.setTimestamp(6, java.sql.Timestamp.valueOf(investimento.getDataCriacao()));
        stm.setTimestamp(7, java.sql.Timestamp.valueOf(investimento.getDataEdicao()));
        stm.setString(8, investimento.getUsuarioId() != null ? investimento.getUsuarioId().toString() : null);
        stm.setString(9, investimento.getCategoria() != null ? investimento.getCategoria().getId().toString() : null);
        stm.setString(10, investimento.getContaId() != null ? investimento.getContaId().toString() : null);
        stm.executeUpdate();
    }

    public Investimento search(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "SELECT id, nome, tipo, saldo_atual, descricao, data_criacao, data_edicao, id_usuario, id_categoria, id_conta FROM t_fin_investimento WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new EntityNotFoundException("Investimento não encontrado.");
        }

        return mapResultSetToInvestimento(result);
    }

    public List<Investimento> getAll() throws SQLException {
        String sql = "SELECT id, nome, tipo, saldo_atual, descricao, data_criacao, data_edicao, id_usuario, id_categoria, id_conta FROM t_fin_investimento ORDER BY data_criacao DESC";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Investimento> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(mapResultSetToInvestimento(result));
        }

        return lista;
    }

    public void update(Investimento investimento) throws SQLException {
        investimento.setDataEdicao(java.time.LocalDateTime.now());
        String sql = "UPDATE t_fin_investimento SET nome = ?, tipo = ?, saldo_atual = ?, descricao = ?, data_edicao = ?, id_categoria = ? WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, investimento.getNome());
        stm.setString(2, investimento.getClass().getSimpleName());
        stm.setDouble(3, investimento.getValor());
        stm.setString(4, investimento.getDescricao());
        stm.setTimestamp(5, java.sql.Timestamp.valueOf(investimento.getDataEdicao()));
        stm.setString(6, investimento.getCategoria() != null ? investimento.getCategoria().getId().toString() : null);
        stm.setString(7, investimento.getId().toString());
        stm.executeUpdate();
    }

    public void delete(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "DELETE FROM t_fin_investimento WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());

        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException("Investimento não encontrado para ser removido");
        }
    }

    private Investimento mapResultSetToInvestimento(ResultSet result) throws SQLException {
        Investimento investimento = new Investimento();
        investimento.setId(UUID.fromString(result.getString("id")));
        investimento.setNome(result.getString("nome"));
        investimento.setValor(result.getDouble("saldo_atual"));
        investimento.setDescricao(result.getString("descricao"));
        return investimento;
    }

    public void closeConnection() throws SQLException {
        conexao.close();
    }
}