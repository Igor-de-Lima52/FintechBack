package br.com.fiap.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Banco{
    private UUID id;
    private String nome;
    private Usuario usuario;
    private boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEdicao;

    private List<Conta> contas = new ArrayList<>();

    public Banco() {
        this.id = UUID.randomUUID();
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public Banco(String nome, Usuario usuario) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.usuario = usuario;
        this.status = true;
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public UUID getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Banco setNome(String nome) {
        this.nome = nome;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Banco setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void inativarBanco(){
        this.status = false;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDateTime getDataEdicao() {
        return this.dataEdicao;
    }

    public List<Conta> getContas() {
        return this.contas;
    }

    public List<Conta> adicionarConta(Conta conta) {
        if(!contas.contains(conta)) {
            this.contas.add(conta);
        }
        return this.contas;
    }

    public List<Conta> deletarConta(Conta conta) {
        if(contas.contains(conta)) {
            this.contas.remove(conta);
            System.out.println("Remoção da conta realizada com sucesso!");
        } else {
            System.out.println("Erro: Essa conta não existe na lista.");
        }
        return this.contas;
    }
}
