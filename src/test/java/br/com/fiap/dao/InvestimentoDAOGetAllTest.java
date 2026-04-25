package br.com.fiap.dao;

import br.com.fiap.model.Investimento;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class InvestimentoDAOGetAllTest {

    private InvestimentoDAO investimentoDAO;

    @Before
    public void setup() throws SQLException {
        investimentoDAO = new InvestimentoDAO();
    }

    @Test
    public void testGetAllInvestimentos() throws SQLException {
        List<Investimento> listaInvestimentos = investimentoDAO.getAll();
        for (Investimento i : listaInvestimentos) {
            System.out.println("Nome: " + i.getNome() + " | Valor: R$" + i.getValor());
        }
    }
}