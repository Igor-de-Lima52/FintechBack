package br.com.fiap.dt_money.model;

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
@Table(name = "t_fin_banco")

public class Banco{
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Usuario usuario;

    private boolean status;

    @Column(name = "data_criacao")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "data_edicao")
    @UpdateTimestamp
    private LocalDateTime dataEdicao;

    private List<Conta> contas = new ArrayList<>();


    public Banco(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
        this.status = true;
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    public void inativarBanco(){
        this.status = false;
    }

    public List<Conta> adicionarConta(Conta conta) {
        if(!contas.contains(conta)) {
            this.contas.add(conta);
        }
        this.dataEdicao = LocalDateTime.now();
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
