package br.com.fiap.dao;

import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Despesa;
import br.com.fiap.model.Receita;
import br.com.fiap.model.Investimento;
import br.com.fiap.model.Saque;
import br.com.fiap.model.Aporte;
import br.com.fiap.model.Transacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransacaoDAO {
    private Connection conexao;

    public TransacaoDAO() throws SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void insert(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO t_fin_transacao (id, nome, valor, tipo, descricao, data_criacao, data_edicao, id_categoria, id_investimento, id_usuario, id_conta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, transacao.getId().toString());
        stm.setString(2, transacao.getNome());
        stm.setDouble(3, transacao.getValor());
        stm.setString(4, transacao.getClass().getSimpleName());
        stm.setString(5, transacao.getDescricao());
        stm.setTimestamp(6, java.sql.Timestamp.valueOf(transacao.getDataCriacao()));
        stm.setTimestamp(7, java.sql.Timestamp.valueOf(transacao.getDataEdicao()));
        stm.setString(8, transacao.getCategoria() != null ? transacao.getCategoria().getId().toString() : null);
        stm.setString(9, null);
        stm.setString(10, transacao.getUsuarioId() != null ? transacao.getUsuarioId().toString() : null);
        stm.setString(11, transacao.getContaId() != null ? transacao.getContaId().toString() : null);
        stm.executeUpdate();
    }

    public Transacao search(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "SELECT id, nome, valor, tipo, descricao, data_criacao, data_edicao, id_categoria, id_investimento, id_usuario, id_conta FROM t_fin_transacao WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new EntityNotFoundException("Transação não encontrada.");
        }

        return mapResultSetToTransacao(result);
    }

    public List<Transacao> getAll() throws SQLException {
        String sql = "SELECT id, nome, valor, tipo, descricao, data_criacao, data_edicao, id_categoria, id_investimento, id_usuario, id_conta FROM t_fin_transacao ORDER BY data_criacao DESC";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Transacao> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(mapResultSetToTransacao(result));
        }

        return lista;
    }

    public void update(Transacao transacao) throws SQLException {
        transacao.setDataEdicao(java.time.LocalDateTime.now());
        String sql = "UPDATE t_fin_transacao SET nome = ?, valor = ?, descricao = ?, data_edicao = ?, id_categoria = ? WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, transacao.getNome());
        stm.setDouble(2, transacao.getValor());
        stm.setString(3, transacao.getDescricao());
        stm.setTimestamp(4, java.sql.Timestamp.valueOf(transacao.getDataEdicao()));
        stm.setString(5, transacao.getCategoria() != null ? transacao.getCategoria().getId().toString() : null);
        stm.setString(6, transacao.getId().toString());
        stm.executeUpdate();
    }

    public void delete(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "DELETE FROM t_fin_transacao WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());

        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException("Transação não encontrada para ser removida");
        }
    }

    private Transacao mapResultSetToTransacao(ResultSet result) throws SQLException {
        String tipo = result.getString("tipo");
        Transacao transacao;

        switch (tipo) {
            case "Despesa":
                transacao = new Despesa();
                break;
            case "Receita":
                transacao = new Receita();
                break;
            case "Investimento":
                transacao = new Investimento();
                break;
            case "Saque":
                transacao = new Saque();
                break;
            case "Aporte":
                transacao = new Aporte();
                break;
            default:
                transacao = new Transacao();
        }

        transacao.setId(UUID.fromString(result.getString("id")));
        transacao.setNome(result.getString("nome"));
        transacao.setValor(result.getDouble("valor"));
        transacao.setDescricao(result.getString("descricao"));

        return transacao;
    }

    public void closeConnection() throws SQLException {
        conexao.close();
    }
}