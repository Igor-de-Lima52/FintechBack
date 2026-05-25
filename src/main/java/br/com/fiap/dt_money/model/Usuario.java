package br.com.fiap.dt_money.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "t_fin_usuario")
public class Usuario {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @CPF(message = "CPF Inválido")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 números")
    @Column(length = 11, nullable = false)
    private String cpf;

    @Email(message = "Email Inválido")
    @Column(length = 255, nullable = false)
    private String email;

    @Column(name = "senha_hash", nullable = false, length = 255)
    private String senhaHash;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Sexo sexo;

    public enum Sexo{MASCULINO, FEMININO, OUTRO}

    @Past(message = "A data de nascimento deve estar no passado")
    @Column(nullable = false)
    private LocalDateTime dataNascimento;

    @Column(name = "data_criacao")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "data_edicao")
    @UpdateTimestamp
    private LocalDateTime dataEdicao;

    @ManyToMany
    @JoinTable(
            name = "t_fin_usuario_banco",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "banco_id")
    )
    private List<Banco> bancos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Conta> contas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String email, String senhaHash, Sexo sexo, LocalDateTime dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senhaHash = senhaHash;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public void adicionarConta(Conta conta) {
        if (!contas.contains(conta)) {
            contas.add(conta);
        }
    }

    public void deletarConta(Conta conta) {
        this.contas.remove(conta);
    }


}
