package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;

import java.sql.SQLException;

public class InsertContaView {
    public static void main(String[] args) {
        try {
            ContaDAO dao = new ContaDAO();
            Conta conta = new Conta("Conta Corrente");
            dao.insert(conta);
            dao.closeConnection();
            System.out.println("Conta cadastrada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}