package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;
import br.com.fiap.model.Login;
import br.com.fiap.exception.EntityNotFoundException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UpdateUsuarioView {
    public static void main(String[] args) {
        try {
            String cpf = String.format("%011d", System.currentTimeMillis() % 100000000000L);
            String email = "test" + System.currentTimeMillis() + "@email.com";

            UsuarioDAO dao = new UsuarioDAO();
            Login login = new Login("usuario1", "senha123");
            Usuario usuario = new Usuario("João Silva", cpf, email, "senha123", login, "M", LocalDateTime.of(1990, 5, 15, 0, 0));
            dao.insert(usuario);

            usuario.setNome("Maria Silva");
            dao.update(usuario);

            dao.delete(usuario.getId());
            dao.closeConnection();

            System.out.println("Usuário atualizado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}