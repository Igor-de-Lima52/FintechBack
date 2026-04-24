package br.com.fiap;

import br.com.fiap.dao.BancoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.ContaDAO;
import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.dao.TransacaoDAO;
import br.com.fiap.dao.InvestimentoDAO;
import br.com.fiap.model.Banco;
import br.com.fiap.model.Usuario;
import br.com.fiap.model.Conta;
import br.com.fiap.model.Categoria;
import br.com.fiap.model.Transacao;
import br.com.fiap.model.Investimento;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class App {
    public static void main(String[] args) {

        try {
            /*Usuario*/
            System.out.println("\n=== USUARIOS ===");
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            Usuario usuario1 = new Usuario();
            usuario1.setNome("João Silva");
            usuario1.setCpf("12345678901");
            usuario1.setEmail("joao@email.com");
            usuario1.setSenha("password123");
            usuario1.setSexo("M");
            usuario1.setDataNascimento(LocalDateTime.of(1990, 5, 15, 0, 0));
            usuarioDAO.insert(usuario1);
            System.out.println("Usuario 1 cadastrado com sucesso!");

            Usuario usuario2 = new Usuario();
            usuario2.setNome("Maria Santos");
            usuario2.setCpf("98765432109");
            usuario2.setEmail("maria@email.com");
            usuario2.setSenha("password123");
            usuario2.setSexo("F");
            usuario2.setDataNascimento(LocalDateTime.of(1985, 8, 22, 0, 0));
            usuarioDAO.insert(usuario2);
            System.out.println("Usuario 2 cadastrado com sucesso!");

            Usuario usuario3 = new Usuario();
            usuario3.setNome("Pedro Oliveira");
            usuario3.setCpf("45678912300");
            usuario3.setEmail("pedro@email.com");
            usuario3.setSenha("password123");
            usuario3.setSexo("M");
            usuario3.setDataNascimento(LocalDateTime.of(1992, 3, 10, 0, 0));
            usuarioDAO.insert(usuario3);
            System.out.println("Usuario 3 cadastrado com sucesso!");

            Usuario usuario4 = new Usuario();
            usuario4.setNome("Ana Costa");
            usuario4.setCpf("32165498700");
            usuario4.setEmail("ana@email.com");
            usuario4.setSenha("password123");
            usuario4.setSexo("F");
            usuario4.setDataNascimento(LocalDateTime.of(1988, 11, 30, 0, 0));
            usuarioDAO.insert(usuario4);
            System.out.println("Usuario 4 cadastrado com sucesso!");

            Usuario usuario5 = new Usuario();
            usuario5.setNome("Carlos Souza");
            usuario5.setCpf("65432198700");
            usuario5.setEmail("carlos@email.com");
            usuario5.setSenha("password123");
            usuario5.setSexo("M");
            usuario5.setDataNascimento(LocalDateTime.of(1995, 7, 8, 0, 0));
            usuarioDAO.insert(usuario5);
            System.out.println("Usuario 5 cadastrado com sucesso!");

            System.out.println("\n--- Lista de usuarios ---");
            List<Usuario> listaUsuarios = usuarioDAO.getAll();
            for (Usuario u : listaUsuarios) {
                System.out.println("Nome: " + u.getNome() + " | Email: " + u.getEmail());
            }

            usuarioDAO.closeConnection();
            /*Banco*/

            BancoDAO bancoDAO = new BancoDAO();

            Banco banco1 = new Banco();
            banco1.setId(UUID.randomUUID());
            banco1.setNome("Banco do Brasil");
            banco1.setStatus(true);
            bancoDAO.insert(banco1);
            System.out.println("Banco 1 cadastrado com sucesso!");

            Banco banco2 = new Banco();
            banco2.setId(UUID.randomUUID());
            banco2.setNome("Itaú");
            banco2.setStatus(true);
            bancoDAO.insert(banco2);
            System.out.println("Banco 2 cadastrado com sucesso!");

            Banco banco3 = new Banco();
            banco3.setId(UUID.randomUUID());
            banco3.setNome("Bradesco");
            banco3.setStatus(true);
            bancoDAO.insert(banco3);
            System.out.println("Banco 3 cadastrado com sucesso!");

            Banco banco4 = new Banco();
            banco4.setId(UUID.randomUUID());
            banco4.setNome("Nubank");
            banco4.setStatus(true);
            bancoDAO.insert(banco4);
            System.out.println("Banco 4 cadastrado com sucesso!");

            Banco banco5 = new Banco();
            banco5.setId(UUID.randomUUID());
            banco5.setNome("Caixa Econômica");
            banco5.setStatus(true);
            bancoDAO.insert(banco5);
            System.out.println("Banco 5 cadastrado com sucesso!");

            System.out.println("\n--- Lista de bancos ---");
            List<Banco> lista = bancoDAO.getAll();
            for (Banco b : lista) {
                System.out.println("Nome: " + b.getNome());
            }

            bancoDAO.closeConnection();

            System.out.println("\n=== CONTAS ===");
            ContaDAO contaDAO = new ContaDAO();

            Conta conta1 = new Conta();
            conta1.setId(UUID.randomUUID());
            conta1.setNome("Conta Corrente");
            conta1.setStatus(true);
            contaDAO.insert(conta1);
            System.out.println("Conta 1 cadastrada com sucesso!");

            Conta conta2 = new Conta();
            conta2.setId(UUID.randomUUID());
            conta2.setNome("Conta Poupança");
            conta2.setStatus(true);
            contaDAO.insert(conta2);
            System.out.println("Conta 2 cadastrada com sucesso!");

            Conta conta3 = new Conta();
            conta3.setId(UUID.randomUUID());
            conta3.setNome("Conta Salário");
            conta3.setStatus(true);
            contaDAO.insert(conta3);
            System.out.println("Conta 3 cadastrada com sucesso!");

            Conta conta4 = new Conta();
            conta4.setId(UUID.randomUUID());
            conta4.setNome("Conta Empresarial");
            conta4.setStatus(true);
            contaDAO.insert(conta4);
            System.out.println("Conta 4 cadastrada com sucesso!");

            Conta conta5 = new Conta();
            conta5.setId(UUID.randomUUID());
            conta5.setNome("Conta Internacional");
            conta5.setStatus(true);
            contaDAO.insert(conta5);
            System.out.println("Conta 5 cadastrada com sucesso!");

            System.out.println("\n--- Lista de contas ---");
            List<Conta> listaContas = contaDAO.getAll();
            for (Conta c : listaContas) {
                System.out.println("Nome: " + c.getNome() + " | Status: " + (c.getStatus() ? "Ativa" : "Inativa"));
            }

            contaDAO.closeConnection();



            System.out.println("\n=== CATEGORIAS ===");
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            Categoria cat1 = new Categoria();
            cat1.setId(UUID.randomUUID());
            cat1.setNome("Salário");
            cat1.setTipo("Receita");
            categoriaDAO.insert(cat1);
            System.out.println("Categoria 1 cadastrada com sucesso!");

            Categoria cat2 = new Categoria();
            cat2.setId(UUID.randomUUID());
            cat2.setNome("Alimentação");
            cat2.setTipo("Despesa");
            categoriaDAO.insert(cat2);
            System.out.println("Categoria 2 cadastrada com sucesso!");

            Categoria cat3 = new Categoria();
            cat3.setId(UUID.randomUUID());
            cat3.setNome("Transporte");
            cat3.setTipo("Despesa");
            categoriaDAO.insert(cat3);
            System.out.println("Categoria 3 cadastrada com sucesso!");

            Categoria cat4 = new Categoria();
            cat4.setId(UUID.randomUUID());
            cat4.setNome("Renda Extra");
            cat4.setTipo("Receita");
            categoriaDAO.insert(cat4);
            System.out.println("Categoria 4 cadastrada com sucesso!");

            Categoria cat5 = new Categoria();
            cat5.setId(UUID.randomUUID());
            cat5.setNome("Lazer");
            cat5.setTipo("Despesa");
            categoriaDAO.insert(cat5);
            System.out.println("Categoria 5 cadastrada com sucesso!");

            System.out.println("\n--- Lista de categorias ---");
            List<Categoria> listaCat = categoriaDAO.getAll();
            for (Categoria c : listaCat) {
                System.out.println("Nome: " + c.getNome() + " | Tipo: " + c.getTipo());
            }

            categoriaDAO.closeConnection();





            System.out.println("\n=== TRANSACOES ===");
            TransacaoDAO transacaoDAO = new TransacaoDAO();

            Transacao transacao1 = new Transacao();
            transacao1.setId(UUID.randomUUID());
            transacao1.setNome("Recebimento Salário");
            transacao1.setDescricao("Salário mensal");
            transacao1.setValor(5000.00);
            transacao1.setCategoria(cat1);
            transacao1.setUsuarioId(usuario1.getId());
            transacao1.setContaId(conta1.getId());
            transacaoDAO.insert(transacao1);
            System.out.println("Transacao 1 cadastrada com sucesso!");

            Transacao transacao2 = new Transacao();
            transacao2.setId(UUID.randomUUID());
            transacao2.setNome("Supermercado");
            transacao2.setDescricao("Compras da semana");
            transacao2.setValor(350.50);
            transacao2.setCategoria(cat2);
            transacao2.setUsuarioId(usuario2.getId());
            transacao2.setContaId(conta2.getId());
            transacaoDAO.insert(transacao2);
            System.out.println("Transacao 2 cadastrada com sucesso!");

            Transacao transacao3 = new Transacao();
            transacao3.setId(UUID.randomUUID());
            transacao3.setNome("Uber");
            transacao3.setDescricao("Transporte semanal");
            transacao3.setValor(120.00);
            transacao3.setCategoria(cat3);
            transacao3.setUsuarioId(usuario3.getId());
            transacao3.setContaId(conta3.getId());
            transacaoDAO.insert(transacao3);
            System.out.println("Transacao 3 cadastrada com sucesso!");

            Transacao transacao4 = new Transacao();
            transacao4.setId(UUID.randomUUID());
            transacao4.setNome("Freelance");
            transacao4.setDescricao("Projeto extra");
            transacao4.setValor(1500.00);
            transacao4.setCategoria(cat4);
            transacao4.setUsuarioId(usuario4.getId());
            transacao4.setContaId(conta4.getId());
            transacaoDAO.insert(transacao4);
            System.out.println("Transacao 4 cadastrada com sucesso!");

            Transacao transacao5 = new Transacao();
            transacao5.setId(UUID.randomUUID());
            transacao5.setNome("Cinema");
            transacao5.setDescricao("Filme e pipoca");
            transacao5.setValor(80.00);
            transacao5.setCategoria(cat5);
            transacao5.setUsuarioId(usuario5.getId());
            transacao5.setContaId(conta5.getId());
            transacaoDAO.insert(transacao5);
            System.out.println("Transacao 5 cadastrada com sucesso!");

            System.out.println("\n--- Lista de transacoes ---");
            List<Transacao> listaTransacoes = transacaoDAO.getAll();
            for (Transacao t : listaTransacoes) {
                System.out.println("Nome: " + t.getNome() + " | Valor: R$" + t.getValor());
            }

            transacaoDAO.closeConnection();

            System.out.println("\n=== INVESTIMENTOS ===");
            InvestimentoDAO investimentoDAO = new InvestimentoDAO();

            Investimento investimento1 = new Investimento();
            investimento1.setId(UUID.randomUUID());
            investimento1.setNome("TESouro Direto");
            investimento1.setDescricao("Investimento de longo prazo");
            investimento1.setValor(1000.00);
            investimento1.setCategoria(cat4);
            investimento1.setUsuarioId(usuario1.getId());
            investimento1.setContaId(conta1.getId());
            investimentoDAO.insert(investimento1);
            System.out.println("Investimento 1 cadastrado com sucesso!");

            Investimento investimento2 = new Investimento();
            investimento2.setId(UUID.randomUUID());
            investimento2.setNome("CDB Banco");
            investimento2.setDescricao("Renda fixa");
            investimento2.setValor(5000.00);
            investimento2.setCategoria(cat4);
            investimento2.setUsuarioId(usuario2.getId());
            investimento2.setContaId(conta2.getId());
            investimentoDAO.insert(investimento2);
            System.out.println("Investimento 2 cadastrado com sucesso!");

            Investimento investimento3 = new Investimento();
            investimento3.setId(UUID.randomUUID());
            investimento3.setNome("Ações B3");
            investimento3.setDescricao("Renda variável");
            investimento3.setValor(2000.00);
            investimento3.setCategoria(cat4);
            investimento3.setUsuarioId(usuario3.getId());
            investimento3.setContaId(conta3.getId());
            investimentoDAO.insert(investimento3);
            System.out.println("Investimento 3 cadastrado com sucesso!");

            Investimento investimento4 = new Investimento();
            investimento4.setId(UUID.randomUUID());
            investimento4.setNome("Fundo Imobiliário");
            investimento4.setDescricao("Investimento em imóveis");
            investimento4.setValor(3000.00);
            investimento4.setCategoria(cat4);
            investimento4.setUsuarioId(usuario4.getId());
            investimento4.setContaId(conta4.getId());
            investimentoDAO.insert(investimento4);
            System.out.println("Investimento 4 cadastrado com sucesso!");

            Investimento investimento5 = new Investimento();
            investimento5.setId(UUID.randomUUID());
            investimento5.setNome("Poupança");
            investimento5.setDescricao("Reserva de emergência");
            investimento5.setValor(1500.00);
            investimento5.setCategoria(cat4);
            investimento5.setUsuarioId(usuario5.getId());
            investimento5.setContaId(conta5.getId());
            investimentoDAO.insert(investimento5);
            System.out.println("Investimento 5 cadastrado com sucesso!");

            System.out.println("\n--- Lista de investimentos ---");
            List<Investimento> listaInvestimentos = investimentoDAO.getAll();
            for (Investimento i : listaInvestimentos) {
                System.out.println("Nome: " + i.getNome() + " | Valor: R$" + i.getValor());
            }

            investimentoDAO.closeConnection();

        } catch (SQLException e) {
            System.err.println("Erro no banco de dados: " + e.getMessage());
        }
    }
}
