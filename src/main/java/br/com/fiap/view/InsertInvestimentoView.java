package br.com.fiap.view;

import br.com.fiap.dao.InvestimentoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Investimento;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Usuario;
import br.com.fiap.model.Conta;
import br.com.fiap.model.Login;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class InsertInvestimentoView {
    public static void main(String[] args) {
        try {
            // Generate unique CPF and email
            String cpf = String.format("%011d", System.currentTimeMillis() % 100000000000L);
            String email = "test" + System.currentTimeMillis() + "@email.com";

            // Create test category first
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            Categoria categoria = new Categoria("Ações", "Investimento");
            categoriaDAO.insert(categoria);

            // Create test user
            Login login = new Login("testuser", "senha123");
            Usuario usuario = new Usuario("Test User", cpf, email, "senha123", login, "M", LocalDateTime.of(1990, 5, 15, 0, 0));
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.insert(usuario);

            // Create test account
            ContaDAO contaDAO = new ContaDAO();
            Conta conta = new Conta("Conta Teste");
            contaDAO.insert(conta);

            UUID usuarioId = usuario.getId();
            UUID contaId = conta.getId();

            // Create investimento
            InvestimentoDAO investimentoDAO = new InvestimentoDAO();
            Investimento investimento = new Investimento("Tesouro Direto", "Título público", 10000.00, categoria, usuarioId, contaId);
            investimentoDAO.insert(investimento);
            
            // Clean up - delete investimento first, then conta
            investimentoDAO.delete(investimento.getId());
            investimentoDAO.closeConnection();
            contaDAO.delete(conta.getId());
            contaDAO.closeConnection();
            usuarioDAO.delete(usuario.getId());
            usuarioDAO.closeConnection();
            categoriaDAO.delete(categoria.getId());
            categoriaDAO.closeConnection();
            
            System.out.println("Investimento cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}