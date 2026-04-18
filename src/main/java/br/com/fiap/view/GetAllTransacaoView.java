package br.com.fiap.view;

import br.com.fiap.dao.TransacaoDAO;
import br.com.fiap.model.Transacao;

import java.sql.SQLException;
import java.util.List;

public class GetAllTransacaoView {
    public static void main(String[] args) {
        try {
            TransacaoDAO dao = new TransacaoDAO();
            List<Transacao> lista = dao.getAll();
            for (Transacao t : lista) {
                System.out.println("Transação: " + t.getNome());
            }
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}