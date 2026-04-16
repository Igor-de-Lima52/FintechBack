package br.com.fiap.dao;

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

    public void cadastrar(Banco banco) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("");
        //stm.setString();
        //stm.setString();
        stm.executeUpdate();
    }

    public Banco pesquisar(UUID id) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("");
        stm.setString();
        ResultSet result = stm.executeQuery();

        if(!result.next())
            throw new EntidadeNaoEncontradaException("Produto não encontrado.");

        Long id = result.getLong("id");
        String nome = result.getString("nome");


        return new Banco();
    }

    public List<Banco> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_fin_banco");
        ResultSet result = stm.executeQuery();
        List<Banco> lista = new ArrayList<>();

        while(result.next()) {
            Long id = result.getLong("id");
            String nome = result.getString("nome");


            lista.add(new Banco(id, nome));
        }

        return lista;
    }

    public void atualizar(Banco banco) {

    }

    public void remover(UUID id) {

    }
}
