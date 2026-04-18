package br.com.fiap.model;

import java.util.UUID;

public class Investimento extends Transacao {
    private UUID usuarioId;
    private UUID contaId;

    public Investimento(String nome, String descricao, double valor, Categoria categoria, UUID usuarioId, UUID contaId) {
        super(nome, descricao, valor, categoria);
        this.usuarioId = usuarioId;
        this.contaId = contaId;
    }

    public Investimento(String nome, String descricao, double valor, Categoria categoria) {
        super(nome, descricao, valor, categoria);
    }

    public Investimento() {
        super();
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public Investimento setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public UUID getContaId() {
        return contaId;
    }

    public Investimento setContaId(UUID contaId) {
        this.contaId = contaId;
        return this;
    }
}