package br.com.fiap.view;

import br.com.fiap.dao.BancoDAO;
import br.com.fiap.model.Banco;

import java.sql.SQLException;

public class UpdateBancoView {
    public static void main(String[] args) {
        try {
            BancoDAO dao = new BancoDAO();
            Banco banco = new Banco("Banco Atualizado", null);
            dao.insert(banco);
            banco.setNome("Nome Alterado");
            dao.update(banco);
            System.out.println("Banco atualizado!");
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}