package br.com.fiap.view;

import br.com.fiap.dao.BancoDAO;
import br.com.fiap.model.Banco;

import java.sql.SQLException;

public class InsertProdutoView {
    public static void main(String[] args) {
        try {
            BancoDAO dao = new BancoDAO();
            Banco banco = new Banco("Nubank", user);
            dao.insert(banco);
            dao.closeConnection();
            System.out.println("Banco cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
