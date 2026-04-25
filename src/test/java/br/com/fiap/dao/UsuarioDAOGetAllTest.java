package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UsuarioDAOGetAllTest {

    private UsuarioDAO usuarioDAO;

    @Before
    public void setup() throws SQLException {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void testGetAllUsuarios() throws SQLException {
        List<Usuario> listaUsuarios = usuarioDAO.getAll();
        for (Usuario u : listaUsuarios) {
            System.out.println("Nome: " + u.getNome() + " | Email: " + u.getEmail());
        }
    }
}