package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;
import br.com.fiap.model.Login;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class InsertUsuarioView {
    public static void main(String[] args) {
        try {
            String cpf = String.format("%011d", System.currentTimeMillis() % 100000000000L);
            String email = "test" + System.currentTimeMillis() + "@email.com";

            UsuarioDAO dao = new UsuarioDAO();
            Login login = new Login("usuario1", "senha123");
            Usuario usuario = new Usuario("João Silva", cpf, email, "senha123", login, "M", LocalDateTime.of(1990, 5, 15, 0, 0));
            dao.insert(usuario);
            dao.closeConnection();
            System.out.println("Usuário cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}