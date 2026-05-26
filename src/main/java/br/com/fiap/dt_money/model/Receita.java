package br.com.fiap.dt_money.model;

import java.util.UUID;

public class Receita extends Transacao {
    public Receita(String nome, String descricao, double valor, Categoria categoria, Usuario usuario, Conta conta) {
        super(nome, descricao, valor, categoria, usuario, conta);
    }

    public Receita() {
        super();
    }
}