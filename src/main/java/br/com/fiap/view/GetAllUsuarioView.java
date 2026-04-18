package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class GetAllUsuarioView {
    public static void main(String[] args) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> lista = dao.getAll();
            for (Usuario u : lista) {
                System.out.println("Usuário: " + u.getNome());
            }
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}