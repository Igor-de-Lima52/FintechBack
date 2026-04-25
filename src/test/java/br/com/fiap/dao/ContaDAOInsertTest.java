package br.com.fiap.dao;

import br.com.fiap.model.Conta;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.UUID;

public class ContaDAOInsertTest {

    private ContaDAO contaDAO;

    @Before
    public void setup() throws SQLException {
        contaDAO = new ContaDAO();
    }

    @Test
    public void testInsertAllContas() throws SQLException {
        Conta conta1 = new Conta();
        conta1.setId(UUID.randomUUID());
        conta1.setNome("Conta Corrente");
        conta1.setStatus(true);
        contaDAO.insert(conta1);

        Conta conta2 = new Conta();
        conta2.setId(UUID.randomUUID());
        conta2.setNome("Conta Poupança");
        conta2.setStatus(true);
        contaDAO.insert(conta2);

        Conta conta3 = new Conta();
        conta3.setId(UUID.randomUUID());
        conta3.setNome("Conta Salário");
        conta3.setStatus(true);
        contaDAO.insert(conta3);

        Conta conta4 = new Conta();
        conta4.setId(UUID.randomUUID());
        conta4.setNome("Conta Empresarial");
        conta4.setStatus(true);
        contaDAO.insert(conta4);

        Conta conta5 = new Conta();
        conta5.setId(UUID.randomUUID());
        conta5.setNome("Conta Internacional");
        conta5.setStatus(true);
        contaDAO.insert(conta5);
    }
}