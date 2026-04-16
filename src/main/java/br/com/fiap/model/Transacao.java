package br.com.fiap.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transacao {
    private UUID id;
    private String nome;
    private String descricao;
    private double valor;
    private Categoria categoria;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEdicao;

    public Transacao(String nome, String descricao, double valor, Categoria categoria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public Transacao() {
        this.id = UUID.randomUUID();
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public void mostrarTransacao() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Valor: " + this.valor);
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Transacao setNome(String nome) {
        this.nome = nome;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Transacao setDescricao(String descricao) {
        this.descricao = descricao;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public double getValor() {
        return valor;
    }

    public Transacao setValor(double valor) {
        this.valor = valor;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Transacao setCategoria(Categoria categoria) {
        this.categoria = categoria;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDateTime getDataEdicao() {
        return this.dataEdicao;
    }
}

