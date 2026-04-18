package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;
import br.com.fiap.model.Login;
import br.com.fiap.exception.EntityNotFoundException;
import java.sql.SQLException;

public class DeleteUsuarioView {
    public static void main(String[] args) {
        try {
            // Generate unique CPF and email
            String cpf = String.format("%011d", System.currentTimeMillis() % 100000000000L);
            String email = "test" + System.currentTimeMillis() + "@email.com";

            UsuarioDAO dao = new UsuarioDAO();
            
            Login login = new Login("testeuser", "senha123");
            Usuario usuario = new Usuario("João Silva", cpf, email, "senha123", login, "M");
            dao.insert(usuario);
            
            dao.delete(usuario.getId());
            System.out.println("Usuário deletado!");
            
            dao.closeConnection();
            System.out.println("Delete executado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("Entidade não encontrada: " + e.getMessage());
        }
    }
}