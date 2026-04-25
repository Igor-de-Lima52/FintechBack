package br.com.fiap.dao;

import br.com.fiap.model.Banco;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.UUID;

public class BancoDAOInsertTest {

    private BancoDAO bancoDAO;

    @Before
    public void setup() throws SQLException {
        bancoDAO = new BancoDAO();
    }

    @Test
    public void testInsertAllBancos() throws SQLException {
        Banco banco1 = new Banco();
        banco1.setId(UUID.randomUUID());
        banco1.setNome("Banco do Brasil");
        banco1.setStatus(true);
        bancoDAO.insert(banco1);

        Banco banco2 = new Banco();
        banco2.setId(UUID.randomUUID());
        banco2.setNome("Itaú");
        banco2.setStatus(true);
        bancoDAO.insert(banco2);

        Banco banco3 = new Banco();
        banco3.setId(UUID.randomUUID());
        banco3.setNome("Bradesco");
        banco3.setStatus(true);
        bancoDAO.insert(banco3);

        Banco banco4 = new Banco();
        banco4.setId(UUID.randomUUID());
        banco4.setNome("Nubank");
        banco4.setStatus(true);
        bancoDAO.insert(banco4);

        Banco banco5 = new Banco();
        banco5.setId(UUID.randomUUID());
        banco5.setNome("Caixa Econômica");
        banco5.setStatus(true);
        bancoDAO.insert(banco5);
    }
}