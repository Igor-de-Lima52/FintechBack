package br.com.fiap.dt_money.model;

import java.util.UUID;

public class Despesa extends Transacao {
    public Despesa(String nome, String descricao, double valor, Categoria categoria, Usuario usuario, Conta conta) {
        super(nome, descricao, valor, categoria, usuario, conta);
    }

    public Despesa() {
        super();
    }
}