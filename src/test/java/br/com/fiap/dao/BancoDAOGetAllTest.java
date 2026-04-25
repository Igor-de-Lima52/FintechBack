package br.com.fiap.dao;

import br.com.fiap.model.Banco;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class BancoDAOGetAllTest {

    private BancoDAO bancoDAO;

    @Before
    public void setup() throws SQLException {
        bancoDAO = new BancoDAO();
    }

    @Test
    public void testGetAllBancos() throws SQLException {
        List<Banco> lista = bancoDAO.getAll();
        for (Banco b : lista) {
            System.out.println("Nome: " + b.getNome());
        }
    }
}