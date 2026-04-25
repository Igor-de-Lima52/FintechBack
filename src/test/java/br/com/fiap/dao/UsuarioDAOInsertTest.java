package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class UsuarioDAOInsertTest {

    private UsuarioDAO usuarioDAO;

    @Before
    public void setup() throws SQLException {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void testInsertAllUsuarios() throws SQLException {
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João Silva");
        usuario1.setCpf("12345678901");
        usuario1.setEmail("joao@email.com");
        usuario1.setSenha("password123");
        usuario1.setSexo("M");
        usuario1.setDataNascimento(LocalDateTime.of(1990, 5, 15, 0, 0));
        usuarioDAO.insert(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Maria Santos");
        usuario2.setCpf("98765432109");
        usuario2.setEmail("maria@email.com");
        usuario2.setSenha("password123");
        usuario2.setSexo("F");
        usuario2.setDataNascimento(LocalDateTime.of(1985, 8, 22, 0, 0));
        usuarioDAO.insert(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setNome("Pedro Oliveira");
        usuario3.setCpf("45678912300");
        usuario3.setEmail("pedro@email.com");
        usuario3.setSenha("password123");
        usuario3.setSexo("M");
        usuario3.setDataNascimento(LocalDateTime.of(1992, 3, 10, 0, 0));
        usuarioDAO.insert(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.setNome("Ana Costa");
        usuario4.setCpf("32165498700");
        usuario4.setEmail("ana@email.com");
        usuario4.setSenha("password123");
        usuario4.setSexo("F");
        usuario4.setDataNascimento(LocalDateTime.of(1988, 11, 30, 0, 0));
        usuarioDAO.insert(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.setNome("Carlos Souza");
        usuario5.setCpf("65432198700");
        usuario5.setEmail("carlos@email.com");
        usuario5.setSenha("password123");
        usuario5.setSexo("M");
        usuario5.setDataNascimento(LocalDateTime.of(1995, 7, 8, 0, 0));
        usuarioDAO.insert(usuario5);
    }
}