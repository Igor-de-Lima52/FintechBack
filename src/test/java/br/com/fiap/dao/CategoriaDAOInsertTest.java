package br.com.fiap.dao;

import br.com.fiap.model.Categoria;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.UUID;

public class CategoriaDAOInsertTest {

    private CategoriaDAO categoriaDAO;

    @Before
    public void setup() throws SQLException {
        categoriaDAO = new CategoriaDAO();
    }

    @Test
    public void testInsertAllCategorias() throws SQLException {
        Categoria cat1 = new Categoria();
        cat1.setId(UUID.randomUUID());
        cat1.setNome("Salário");
        cat1.setTipo("Receita");
        categoriaDAO.insert(cat1);

        Categoria cat2 = new Categoria();
        cat2.setId(UUID.randomUUID());
        cat2.setNome("Alimentação");
        cat2.setTipo("Despesa");
        categoriaDAO.insert(cat2);

        Categoria cat3 = new Categoria();
        cat3.setId(UUID.randomUUID());
        cat3.setNome("Transporte");
        cat3.setTipo("Despesa");
        categoriaDAO.insert(cat3);

        Categoria cat4 = new Categoria();
        cat4.setId(UUID.randomUUID());
        cat4.setNome("Renda Extra");
        cat4.setTipo("Receita");
        categoriaDAO.insert(cat4);

        Categoria cat5 = new Categoria();
        cat5.setId(UUID.randomUUID());
        cat5.setNome("Lazer");
        cat5.setTipo("Despesa");
        categoriaDAO.insert(cat5);
    }
}