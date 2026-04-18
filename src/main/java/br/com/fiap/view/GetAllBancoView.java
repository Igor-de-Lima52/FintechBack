package br.com.fiap.view;

import br.com.fiap.dao.BancoDAO;
import br.com.fiap.model.Banco;

import java.sql.SQLException;
import java.util.List;

public class GetAllBancoView {
    public static void main(String[] args) {
        try {
            BancoDAO dao = new BancoDAO();
            List<Banco> lista = dao.getAll();
            for (Banco b : lista) {
                System.out.println("Banco: " + b.getNome());
            }
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}