package br.com.fiap.view;

import br.com.fiap.dao.BancoDAO;
import br.com.fiap.model.Banco;

import java.sql.SQLException;

public class InsertBancoView {
    public static void main(String[] args) {
        try {
            BancoDAO dao = new BancoDAO();
            Banco banco = new Banco("Nubank", null);
            dao.insert(banco);
            dao.closeConnection();
            System.out.println("Banco cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
