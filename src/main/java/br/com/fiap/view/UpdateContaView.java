package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;

import java.sql.SQLException;

public class UpdateContaView {
    public static void main(String[] args) {
        try {
            ContaDAO dao = new ContaDAO();
            Conta conta = new Conta("Conta Antiga");
            dao.insert(conta);
            conta.setNome("Conta Nova");
            dao.update(conta);
            System.out.println("Conta atualizada!");
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}