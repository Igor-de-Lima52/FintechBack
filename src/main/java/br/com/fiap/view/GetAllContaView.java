package br.com.fiap.view;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.model.Conta;

import java.sql.SQLException;
import java.util.List;

public class GetAllContaView {
    public static void main(String[] args) {
        try {
            ContaDAO dao = new ContaDAO();
            List<Conta> lista = dao.getAll();
            for (Conta c : lista) {
                System.out.println("Conta: " + c.getNome());
            }
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}