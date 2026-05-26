package br.com.fiap.dt_money.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "t_fin_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private boolean status = true;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_edicao")
    private LocalDateTime dataEdicao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "banco_id", nullable = false)
    private Banco banco;

    @Transient
    private List<Transacao> transacoes = new ArrayList<>();

    public Conta() {}

    public Conta(String nome, Usuario usuario, Banco banco) {
        this.nome = nome;
        this.usuario = usuario;
        this.banco = banco;
    }

    public void inativarConta(){
        this.status = false;
    }

    public void adicionarTransacao(Transacao transacao) {
        if (!transacoes.contains(transacao)) {
            this.transacoes.add(transacao);
        } else {
            System.out.println("Erro: Essa transacao já está na lista");
        }
    }

    public void deletarTransacao(Transacao transacao) {
        if (transacoes.contains(transacao)) {
            this.transacoes.remove(transacao);
            System.out.println("Remoção da transação realizada com sucesso!");
        } else {
            System.out.println("Erro: Essa transação não está na lista");
        }
    }
}

