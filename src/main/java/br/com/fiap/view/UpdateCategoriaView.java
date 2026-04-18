package br.com.fiap.view;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;

import java.sql.SQLException;

public class UpdateCategoriaView {
    public static void main(String[] args) {
        try {
            CategoriaDAO dao = new CategoriaDAO();
            Categoria categoria = new Categoria("Alimentação", "Despesa");
            dao.insert(categoria);
            categoria.setNome("Transporte");
            dao.update(categoria);
            System.out.println("Categoria atualizada!");
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}