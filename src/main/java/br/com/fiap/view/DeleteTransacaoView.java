package br.com.fiap.view;

import br.com.fiap.dao.TransacaoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Despesa;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Usuario;
import br.com.fiap.model.Conta;
import br.com.fiap.model.Login;
import br.com.fiap.exception.EntityNotFoundException;
import java.sql.SQLException;
import java.util.UUID;

public class DeleteTransacaoView {
    public static void main(String[] args) {
        try {
            // Generate unique CPF and email
            String cpf = String.format("%011d", System.currentTimeMillis() % 100000000000L);
            String email = "test" + System.currentTimeMillis() + "@email.com";

            // Create test category first
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            Categoria categoria = new Categoria("Alimentação", "Despesa");
            categoriaDAO.insert(categoria);

            // Create test user
            Login login = new Login("testuser", "senha123");
            Usuario usuario = new Usuario("Test User", cpf, email, "senha123", login, "M");
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.insert(usuario);

            // Create test account
            ContaDAO contaDAO = new ContaDAO();
            Conta conta = new Conta("Conta Teste");
            contaDAO.insert(conta);

            UUID usuarioId = usuario.getId();
            UUID contaId = conta.getId();

            // Create and insert transaction
            TransacaoDAO dao = new TransacaoDAO();
            Despesa transacao = new Despesa("Supermercado", "Compras", 250.00, categoria, usuarioId, contaId);
            dao.insert(transacao);

            // Delete
            dao.delete(transacao.getId());
            dao.closeConnection();
            contaDAO.delete(conta.getId());
            contaDAO.closeConnection();
            usuarioDAO.delete(usuario.getId());
            usuarioDAO.closeConnection();
            categoriaDAO.delete(categoria.getId());
            categoriaDAO.closeConnection();
            
            System.out.println("Transação deletada!");
            System.out.println("Delete executado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("Entidade não encontrada: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}