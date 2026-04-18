package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;
import br.com.fiap.exception.EntityNotFoundException;
import java.sql.SQLException;

public class SearchContaView {
    public static void main(String[] args) {
        try {
            ContaDAO dao = new ContaDAO();
            
            Conta conta = new Conta("Conta Corrente");
            dao.insert(conta);
            
            Conta resultado = dao.search(conta.getId());
            System.out.println("Conta encontrada: " + resultado.getNome());
            
            dao.delete(conta.getId());
            dao.closeConnection();
            System.out.println("Search executado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("Entidade não encontrada: " + e.getMessage());
        }
    }
}