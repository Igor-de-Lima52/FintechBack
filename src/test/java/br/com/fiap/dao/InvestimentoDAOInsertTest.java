package br.com.fiap.dao;

import br.com.fiap.model.Categoria;
import br.com.fiap.model.Conta;
import br.com.fiap.model.Investimento;
import br.com.fiap.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class InvestimentoDAOInsertTest {

    private InvestimentoDAO investimentoDAO;
    private CategoriaDAO categoriaDAO;
    private UsuarioDAO usuarioDAO;
    private ContaDAO contaDAO;

    @Before
    public void setup() throws SQLException {
        investimentoDAO = new InvestimentoDAO();
        categoriaDAO = new CategoriaDAO();
        usuarioDAO = new UsuarioDAO();
        contaDAO = new ContaDAO();
    }

    @Test
    public void testInsertAllInvestimentos() throws SQLException {
        List<Categoria> categorias = categoriaDAO.getAll();
        Categoria cat4 = categorias.stream().filter(c -> c.getNome().equals("Renda Extra")).findFirst().orElse(null);

        List<Usuario> usuarios = usuarioDAO.getAll();
        Usuario usuario1 = usuarios.stream().filter(u -> u.getNome().equals("João Silva")).findFirst().orElse(null);
        Usuario usuario2 = usuarios.stream().filter(u -> u.getNome().equals("Maria Santos")).findFirst().orElse(null);
        Usuario usuario3 = usuarios.stream().filter(u -> u.getNome().equals("Pedro Oliveira")).findFirst().orElse(null);
        Usuario usuario4 = usuarios.stream().filter(u -> u.getNome().equals("Ana Costa")).findFirst().orElse(null);
        Usuario usuario5 = usuarios.stream().filter(u -> u.getNome().equals("Carlos Souza")).findFirst().orElse(null);

        List<Conta> contas = contaDAO.getAll();
        Conta conta1 = contas.stream().filter(c -> c.getNome().equals("Conta Corrente")).findFirst().orElse(null);
        Conta conta2 = contas.stream().filter(c -> c.getNome().equals("Conta Poupança")).findFirst().orElse(null);
        Conta conta3 = contas.stream().filter(c -> c.getNome().equals("Conta Salário")).findFirst().orElse(null);
        Conta conta4 = contas.stream().filter(c -> c.getNome().equals("Conta Empresarial")).findFirst().orElse(null);
        Conta conta5 = contas.stream().filter(c -> c.getNome().equals("Conta Internacional")).findFirst().orElse(null);

        Investimento investimento1 = new Investimento();
        investimento1.setId(UUID.randomUUID());
        investimento1.setNome("Tesouro Direto");
        investimento1.setDescricao("Investimento de longo prazo");
        investimento1.setValor(1000.00);
        investimento1.setCategoria(cat4);
        investimento1.setUsuarioId(usuario1.getId());
        investimento1.setContaId(conta1.getId());
        investimentoDAO.insert(investimento1);

        Investimento investimento2 = new Investimento();
        investimento2.setId(UUID.randomUUID());
        investimento2.setNome("CDB Banco");
        investimento2.setDescricao("Renda fixa");
        investimento2.setValor(5000.00);
        investimento2.setCategoria(cat4);
        investimento2.setUsuarioId(usuario2.getId());
        investimento2.setContaId(conta2.getId());
        investimentoDAO.insert(investimento2);

        Investimento investimento3 = new Investimento();
        investimento3.setId(UUID.randomUUID());
        investimento3.setNome("Ações B3");
        investimento3.setDescricao("Renda variável");
        investimento3.setValor(2000.00);
        investimento3.setCategoria(cat4);
        investimento3.setUsuarioId(usuario3.getId());
        investimento3.setContaId(conta3.getId());
        investimentoDAO.insert(investimento3);

        Investimento investimento4 = new Investimento();
        investimento4.setId(UUID.randomUUID());
        investimento4.setNome("Fundo Imobiliário");
        investimento4.setDescricao("Investimento em imóveis");
        investimento4.setValor(3000.00);
        investimento4.setCategoria(cat4);
        investimento4.setUsuarioId(usuario4.getId());
        investimento4.setContaId(conta4.getId());
        investimentoDAO.insert(investimento4);

        Investimento investimento5 = new Investimento();
        investimento5.setId(UUID.randomUUID());
        investimento5.setNome("Poupança");
        investimento5.setDescricao("Reserva de emergência");
        investimento5.setValor(1500.00);
        investimento5.setCategoria(cat4);
        investimento5.setUsuarioId(usuario5.getId());
        investimento5.setContaId(conta5.getId());
        investimentoDAO.insert(investimento5);
    }
}