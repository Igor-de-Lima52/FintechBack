package br.com.fiap.dao;

import br.com.fiap.model.Transacao;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TransacaoDAOGetAllTest {

    private TransacaoDAO transacaoDAO;

    @Before
    public void setup() throws SQLException {
        transacaoDAO = new TransacaoDAO();
    }

    @Test
    public void testGetAllTransacoes() throws SQLException {
        List<Transacao> listaTransacoes = transacaoDAO.getAll();
        for (Transacao t : listaTransacoes) {
            System.out.println("Nome: " + t.getNome() + " | Valor: R$" + t.getValor());
        }
    }
}