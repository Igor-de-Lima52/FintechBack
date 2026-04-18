package br.com.fiap.view;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;

import java.sql.SQLException;

public class InsertCategoriaView {
    public static void main(String[] args) {
        try {
            CategoriaDAO dao = new CategoriaDAO();
            Categoria categoria = new Categoria("Alimentação", "Despesa");
            dao.insert(categoria);
            dao.closeConnection();
            System.out.println("Categoria cadastrada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}