package br.com.fiap.dao;

import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.model.Banco;
import com.sun.org.apache.xpath.internal.operations.Bool;
import oracle.jdbc.proxy.annotation.Pre;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BancoDAO {
    private Connection conexao;

    public void insert(Banco banco) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO t_fin_banco (id, nome, status) VALUES (?, ?, ?)");
        stm.setString(1, banco.getId());
        stm.setString(2, banco.getNome());
        stm.setLong(3, banco.getStatus() ? 'T' : 'F');
        stm.executeUpdate();
    }

    public Banco search(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "SELECT id, nome, status WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet result = stm.executeQuery();

        if(!result.next())
            throw new EntityNotFoundException("Produto não encontrado.");

        String id = result.getString("id");
        String nome = result.getString("nome");
        Boolean status = result.getBoolean("status");

        return new Banco();
    }

    public List<Banco> getAll() throws SQLException {
        String sql = "SELECT id, nome, status FROM tb_fin_banco ORDER BY id";
        //String sqlGetUser = "SELECT id_usuario FROM tb_fin_usuario_conta WHERE id_conta = ?";

        PreparedStatement stm = conexao.prepareStatement(sql);
        //PreparedStatement stmUserBank = conexao.prepareStatement(sqlGetUser);
        ResultSet result = stm.executeQuery();
        List<Banco> lista = new ArrayList<>();

        while(result.next()) {
            String id = result.getString("id");
            String nome = result.getString("nome");

          //  stmUserBank.setString(1, id);

            lista.add(new Banco(id, nome, user));
        }

        return lista;
    }

    public void update(Banco banco) throws SQLException {
        String sql = "UPDATE tb_fin_banco SET nome = ?, status = ?";

        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, banco.getNome());
        stm.setBoolean(2, banco.getStatus());
    }

    public void delete(UUID id) throws SQLException, EntityNotFoundException{
        String sql = "DELETE tb_fin_banco WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id);

        int linha = stm.executeUpdate();

        if(linha == 0)
            throw new EntityNotFoundException("Banco não encontrado para ser removido");
    }

    public void closeConnection() throws SQLException {
        conexao.close();
    }

}
