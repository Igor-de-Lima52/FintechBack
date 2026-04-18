package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;
import br.com.fiap.exception.EntityNotFoundException;
import java.sql.SQLException;

public class DeleteContaView {
    public static void main(String[] args) {
        try {
            ContaDAO dao = new ContaDAO();
            
            Conta conta = new Conta("Conta Corrente");
            dao.insert(conta);
            
            dao.delete(conta.getId());
            System.out.println("Conta deletada!");
            
            dao.closeConnection();
            System.out.println("Delete executado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("Entidade não encontrada: " + e.getMessage());
        }
    }
}