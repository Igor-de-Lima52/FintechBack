package br.com.fiap;

import br.com.fiap.dao.BancoDAO;
import br.com.fiap.model.Banco;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class App {
    public static void main(String[] args) {

        try {
            BancoDAO bancoDAO = new BancoDAO();

            Banco banco1 = new Banco();
            banco1.setId(UUID.randomUUID());
            banco1.setNome("Banco do Brasil");
            banco1.setStatus(true);
            banco1.setDataCriacao(LocalDateTime.now());
            banco1.setDataEdicao(LocalDateTime.now());
            bancoDAO.insert(banco1);
            System.out.println("Banco 1 cadastrado com sucesso!");

            Banco banco2 = new Banco();
            banco2.setId(UUID.randomUUID());
            banco2.setNome("Itaú");
            banco2.setStatus(true);
            banco2.setDataCriacao(LocalDateTime.now());
            banco2.setDataEdicao(LocalDateTime.now());
            bancoDAO.insert(banco2);
            System.out.println("Banco 2 cadastrado com sucesso!");

            Banco banco3 = new Banco();
            banco3.setId(UUID.randomUUID());
            banco3.setNome("Bradesco");
            banco3.setStatus(true);
            banco3.setDataCriacao(LocalDateTime.now());
            banco3.setDataEdicao(LocalDateTime.now());
            bancoDAO.insert(banco3);
            System.out.println("Banco 3 cadastrado com sucesso!");

            Banco banco4 = new Banco();
            banco4.setId(UUID.randomUUID());
            banco4.setNome("Nubank");
            banco4.setStatus(true);
            banco4.setDataCriacao(LocalDateTime.now());
            banco4.setDataEdicao(LocalDateTime.now());
            bancoDAO.insert(banco4);
            System.out.println("Banco 4 cadastrado com sucesso!");

            Banco banco5 = new Banco();
            banco5.setId(UUID.randomUUID());
            banco5.setNome("Caixa Econômica");
            banco5.setStatus(true);
            banco5.setDataCriacao(LocalDateTime.now());
            banco5.setDataEdicao(LocalDateTime.now());
            bancoDAO.insert(banco5);
            System.out.println("Banco 5 cadastrado com sucesso!");

            System.out.println("\n--- Lista de bancos ---");
            List<Banco> lista = bancoDAO.getAll();
            for (Banco b : lista) {
                System.out.println("Nome: " + b.getNome());
            }

            bancoDAO.closeConnection();

        } catch (SQLException e) {
            System.err.println("Erro no banco de dados: " + e.getMessage());
        }
    }
}
