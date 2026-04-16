package br.com.fiap.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conta {
    private UUID id;
    private String nome;
    private Usuario usuario;
    private boolean status = true;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEdicao;

    private List<Transacao> transacoes = new ArrayList<>();

    public Conta() {
        this.id = UUID.randomUUID();
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public Conta(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public UUID getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public Conta setNome(String nome) {
        this.nome = nome;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Conta setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void inativarConta(){
        this.status = false;
    }

    public List<Transacao> getTransacoes() {
        return this.transacoes;
    }

    public List<Transacao> adicionarTransacao(Transacao transacao) {
        if(!transacoes.contains(transacao)) {
            this.transacoes.add(transacao);
        } else {
            System.out.println("Erro: Essa transacao já está na lista");
        }
        return this.transacoes;
    }

    public List<Transacao> deletarTransacao(Transacao transacao) {
        if(transacoes.contains(transacao)) {
            this.transacoes.remove(transacao);
            System.out.println("Remoção da transação realizada com sucesso!");
        } else {
            System.out.println("Erro: Essa transação não está na lista");
        }
        return this.transacoes;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDateTime getDataEdicao() {
        return this.dataEdicao;
    }
}

