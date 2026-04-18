package br.com.fiap.model;

import java.util.UUID;

public class Receita extends Transacao {
    public Receita(String nome, String descricao, double valor, Categoria categoria, UUID usuarioId, UUID contaId) {
        super(nome, descricao, valor, categoria, usuarioId, contaId);
    }

    public Receita(String nome, String descricao, double valor, Categoria categoria) {
        super(nome, descricao, valor, categoria);
    }

    public Receita() { super(); }
}