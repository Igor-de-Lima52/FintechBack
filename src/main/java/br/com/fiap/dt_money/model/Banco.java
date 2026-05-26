package br.com.fiap.dt_money.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(unique = true)
    private Integer codigo;

    @JsonIgnore
    @OneToMany(mappedBy = "banco")
    private List<Conta> contas = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "bancos")
    private List<Usuario> usuario = new ArrayList<>();
}
