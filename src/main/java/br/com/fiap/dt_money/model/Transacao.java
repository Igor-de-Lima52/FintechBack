package br.com.fiap.dt_money.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "t_fin_transacao")
@Inheritance(strategy = InheritanceType.JOINED)
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_edicao")
    private LocalDateTime dataEdicao;

    public Transacao(String nome, String descricao, double valor, Categoria categoria, Usuario usuario, Conta conta) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.usuario = usuario;
        this.conta = conta;
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public Transacao() {
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }
}
