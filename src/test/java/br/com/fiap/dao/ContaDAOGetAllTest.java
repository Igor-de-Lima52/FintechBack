package br.com.fiap.dao;

import br.com.fiap.model.Conta;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ContaDAOGetAllTest {

    private ContaDAO contaDAO;

    @Before
    public void setup() throws SQLException {
        contaDAO = new ContaDAO();
    }

    @Test
    public void testGetAllContas() throws SQLException {
        List<Conta> listaContas = contaDAO.getAll();
        for (Conta c : listaContas) {
            System.out.println("Nome: " + c.getNome() + " | Status: " + (c.getStatus() ? "Ativa" : "Inativa"));
        }
    }
}