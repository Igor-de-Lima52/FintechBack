package br.com.fiap.view;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;

import java.sql.SQLException;
import java.util.List;

public class GetAllCategoriaView {
    public static void main(String[] args) {
        try {
            CategoriaDAO dao = new CategoriaDAO();
            List<Categoria> lista = dao.getAll();
            for (Categoria c : lista) {
                System.out.println("Categoria: " + c.getNome());
            }
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}