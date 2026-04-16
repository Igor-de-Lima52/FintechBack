package br.com.fiap.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Categoria {
    private UUID id;
    private String nome;
    private String tipo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEdicao;

    public Categoria(String nome, String tipo) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.tipo = tipo;
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public Categoria() {
        this.id = UUID.randomUUID();
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public Categoria setNome(String nome) {
        this.nome = nome;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Categoria setTipo(String tipo) {
        this.tipo = tipo;
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

