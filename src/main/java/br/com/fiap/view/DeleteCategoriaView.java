package br.com.fiap.view;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;
import br.com.fiap.exception.EntityNotFoundException;
import java.sql.SQLException;

public class DeleteCategoriaView {
    public static void main(String[] args) {
        try {
            CategoriaDAO dao = new CategoriaDAO();
            
            Categoria categoria = new Categoria("Alimentação", "Despesa");
            dao.insert(categoria);
            
            dao.delete(categoria.getId());
            System.out.println("Categoria deletada!");
            
            dao.closeConnection();
            System.out.println("Delete executado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("Entidade não encontrada: " + e.getMessage());
        }
    }
}