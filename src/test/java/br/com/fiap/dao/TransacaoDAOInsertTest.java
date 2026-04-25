package br.com.fiap.dao;

import br.com.fiap.model.Categoria;
import br.com.fiap.model.Conta;
import br.com.fiap.model.Transacao;
import br.com.fiap.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class TransacaoDAOInsertTest {

    private TransacaoDAO transacaoDAO;
    private CategoriaDAO categoriaDAO;
    private UsuarioDAO usuarioDAO;
    private ContaDAO contaDAO;

    @Before
    public void setup() throws SQLException {
        transacaoDAO = new TransacaoDAO();
        categoriaDAO = new CategoriaDAO();
        usuarioDAO = new UsuarioDAO();
        contaDAO = new ContaDAO();
    }

    @Test
    public void testInsertAllTransacoes() throws SQLException {
        List<Categoria> categorias = categoriaDAO.getAll();
        Categoria cat1 = categorias.stream().filter(c -> c.getNome().equals("Salário")).findFirst().orElse(null);
        Categoria cat2 = categorias.stream().filter(c -> c.getNome().equals("Alimentação")).findFirst().orElse(null);
        Categoria cat3 = categorias.stream().filter(c -> c.getNome().equals("Transporte")).findFirst().orElse(null);
        Categoria cat4 = categorias.stream().filter(c -> c.getNome().equals("Renda Extra")).findFirst().orElse(null);
        Categoria cat5 = categorias.stream().filter(c -> c.getNome().equals("Lazer")).findFirst().orElse(null);

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

        Transacao transacao1 = new Transacao();
        transacao1.setId(UUID.randomUUID());
        transacao1.setNome("Recebimento Salário");
        transacao1.setDescricao("Salário mensal");
        transacao1.setValor(5000.00);
        transacao1.setCategoria(cat1);
        transacao1.setUsuarioId(usuario1.getId());
        transacao1.setContaId(conta1.getId());
        transacaoDAO.insert(transacao1);

        Transacao transacao2 = new Transacao();
        transacao2.setId(UUID.randomUUID());
        transacao2.setNome("Supermercado");
        transacao2.setDescricao("Compras da semana");
        transacao2.setValor(350.50);
        transacao2.setCategoria(cat2);
        transacao2.setUsuarioId(usuario2.getId());
        transacao2.setContaId(conta2.getId());
        transacaoDAO.insert(transacao2);

        Transacao transacao3 = new Transacao();
        transacao3.setId(UUID.randomUUID());
        transacao3.setNome("Uber");
        transacao3.setDescricao("Transporte semanal");
        transacao3.setValor(120.00);
        transacao3.setCategoria(cat3);
        transacao3.setUsuarioId(usuario3.getId());
        transacao3.setContaId(conta3.getId());
        transacaoDAO.insert(transacao3);

        Transacao transacao4 = new Transacao();
        transacao4.setId(UUID.randomUUID());
        transacao4.setNome("Freelance");
        transacao4.setDescricao("Projeto extra");
        transacao4.setValor(1500.00);
        transacao4.setCategoria(cat4);
        transacao4.setUsuarioId(usuario4.getId());
        transacao4.setContaId(conta4.getId());
        transacaoDAO.insert(transacao4);

        Transacao transacao5 = new Transacao();
        transacao5.setId(UUID.randomUUID());
        transacao5.setNome("Cinema");
        transacao5.setDescricao("Filme e pipoca");
        transacao5.setValor(80.00);
        transacao5.setCategoria(cat5);
        transacao5.setUsuarioId(usuario5.getId());
        transacao5.setContaId(conta5.getId());
        transacaoDAO.insert(transacao5);
    }
}