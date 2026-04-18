package br.com.fiap.view;

import br.com.fiap.dao.BancoDAO;
import br.com.fiap.exception.EntityNotFoundException;
import java.sql.SQLException;

public class DeleteBancoView {
    public static void main(String[] args) {
        try {
            BancoDAO dao = new BancoDAO();
            
            br.com.fiap.model.Banco banco = new br.com.fiap.model.Banco("Banco Teste", null);
            dao.insert(banco);
            
            dao.delete(banco.getId());
            System.out.println("Banco deletado!");
            
            dao.closeConnection();
            System.out.println("Delete executado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("Entidade não encontrada: " + e.getMessage());
        }
    }
}