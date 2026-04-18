package br.com.fiap.model;

import java.util.UUID;

public class Despesa extends Transacao {
    public Despesa(String nome, String descricao, double valor, Categoria categoria, UUID usuarioId, UUID contaId) {
        super(nome, descricao, valor, categoria, usuarioId, contaId);
    }

    public Despesa(String nome, String descricao, double valor, Categoria categoria) {
        super(nome, descricao, valor, categoria);
    }

    public Despesa() { super(); }
}