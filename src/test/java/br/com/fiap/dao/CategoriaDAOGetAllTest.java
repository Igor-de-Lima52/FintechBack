package br.com.fiap.dao;

import br.com.fiap.model.Categoria;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class CategoriaDAOGetAllTest {

    private CategoriaDAO categoriaDAO;

    @Before
    public void setup() throws SQLException {
        categoriaDAO = new CategoriaDAO();
    }

    @Test
    public void testGetAllCategorias() throws SQLException {
        List<Categoria> listaCat = categoriaDAO.getAll();
        for (Categoria c : listaCat) {
            System.out.println("Nome: " + c.getNome() + " | Tipo: " + c.getTipo());
        }
    }
}