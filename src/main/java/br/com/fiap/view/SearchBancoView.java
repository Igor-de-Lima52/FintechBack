package br.com.fiap.view;

import br.com.fiap.dao.BancoDAO;
import br.com.fiap.model.Banco;
import br.com.fiap.exception.EntityNotFoundException;
import java.sql.SQLException;

public class SearchBancoView {
    public static void main(String[] args) {
        try {
            BancoDAO dao = new BancoDAO();
            
            Banco banco = new Banco("Banco Teste", null);
            dao.insert(banco);
            
            Banco resultado = dao.search(banco.getId());
            System.out.println("Banco encontrado: " + resultado.getNome());
            
            dao.delete(banco.getId());
            dao.closeConnection();
            System.out.println("Search executado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("Entidade não encontrada: " + e.getMessage());
        }
    }
}