package br.com.fiap.view;

import br.com.fiap.dao.InvestimentoDAO;
import br.com.fiap.model.Investimento;

import java.sql.SQLException;
import java.util.List;

public class GetAllInvestimentoView {
    public static void main(String[] args) {
        try {
            InvestimentoDAO dao = new InvestimentoDAO();
            List<Investimento> lista = dao.getAll();
            for (Investimento i : lista) {
                System.out.println("Investimento: " + i.getNome());
            }
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}