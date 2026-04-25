package br.com.fiap.dao;

import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO() throws SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO t_fin_usuario (id, nome, cpf, email, senha_hash, sexo, data_nascimento, data_criacao, data_edicao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, usuario.getId().toString());
        stm.setString(2, usuario.getNome());
        stm.setString(3, usuario.getCpf());
        stm.setString(4, usuario.getEmail());
        stm.setString(5, usuario.getSenha());
        stm.setString(6, usuario.getSexo());
        stm.setTimestamp(7, java.sql.Timestamp.valueOf(usuario.getDataNascimento()));
        stm.setTimestamp(8, java.sql.Timestamp.valueOf(usuario.getDataCriacao()));
        stm.setTimestamp(9, java.sql.Timestamp.valueOf(usuario.getDataEdicao()));
        stm.executeUpdate();
    }

    public Usuario search(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "SELECT id, nome, cpf, email, senha_hash, sexo, data_nascimento, data_criacao, data_edicao FROM t_fin_usuario WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet result = stm.executeQuery();

        if (!result.next()) {
            throw new EntityNotFoundException("Usuário não encontrado.");
        }

        return mapResultSetToUsuario(result);
    }

    public List<Usuario> getAll() throws SQLException {
        String sql = "SELECT id, nome, cpf, email, senha_hash, sexo, data_nascimento, data_criacao, data_edicao FROM t_fin_usuario ORDER BY id";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Usuario> lista = new ArrayList<>();

        while (result.next()) {
            lista.add(mapResultSetToUsuario(result));
        }

        return lista;
    }

    public void update(Usuario usuario) throws SQLException {
        usuario.setDataEdicao(java.time.LocalDateTime.now());
        String sql = "UPDATE t_fin_usuario SET nome = ?, cpf = ?, email = ?, senha_hash = ?, sexo = ?, data_edicao = ? WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getCpf());
        stm.setString(3, usuario.getEmail());
        stm.setString(4, usuario.getSenha());
        stm.setString(5, usuario.getSexo());
        stm.setTimestamp(6, java.sql.Timestamp.valueOf(usuario.getDataEdicao()));
        stm.setString(7, usuario.getId().toString());
        stm.executeUpdate();
    }

    public void delete(UUID id) throws SQLException, EntityNotFoundException {
        String sql = "DELETE FROM t_fin_usuario WHERE id = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, id.toString());

        int linha = stm.executeUpdate();

        if (linha == 0) {
            throw new EntityNotFoundException("Usuário não encontrado para ser removido");
        }
    }

    private Usuario mapResultSetToUsuario(ResultSet result) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(UUID.fromString(result.getString("id")));
        usuario.setNome(result.getString("nome"));
        usuario.setCpf(result.getString("cpf"));
        usuario.setEmail(result.getString("email"));
        usuario.setSenha(result.getString("senha_hash"));
        usuario.setSexo(result.getString("sexo"));
        return usuario;
    }

    public void closeConnection() throws SQLException {
        conexao.close();
    }
}