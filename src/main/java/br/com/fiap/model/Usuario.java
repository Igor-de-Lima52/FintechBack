package br.com.fiap.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Login login;
    private String sexo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEdicao;

    private List<Conta> contas = new ArrayList<>();
    private List<Banco> bancos = new ArrayList<>();

    public Usuario(String nome, String cpf, String email, String senha, Login login, String sexo) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.login = login;
        this.sexo = sexo;
        this.dataCriacao = LocalDateTime.now();
        this.dataEdicao = LocalDateTime.now();
    }

    //public Usuario() {
    //this.id = UUID.randomUUID();
    //this.dataCriacao = LocalDateTime.now();
    //this.dataEdicao = LocalDateTime.now();
    //}

    public UUID getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Usuario setCpf(String cpf) {
        if(cpf.length() == 11) {
            this.dataEdicao = LocalDateTime.now();
            this.cpf = cpf;
        } else {
            System.out.println("Erro: O cpf não tem a quantidade certa de caracteres.");
        }

        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public String getSexo() {
        return this.sexo;
    }

    public Usuario setSexo(String sexo) {
        this.sexo = sexo;
        this.dataEdicao = LocalDateTime.now();
        return this;
    }

    public String getSenha() {
        return this.senha;
    }

    public Usuario setSenha(String senha) {
        if(senha.length() >= 8) {
            this.senha = senha;
            this.dataEdicao = LocalDateTime.now();
        } else {
            System.out.println("Erro: A senha digitada não tem o mínimo de caracteres.");
        }
        return this;
    }

    public Login getLogin() {
        return this.login;
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
        if (!contas.contains(conta)) {
            contas.add(conta);
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

    public List<Banco> getBancos() {
        return this.bancos;
    }

    public List<Banco> adicionarBanco(Banco banco) {
        if (!bancos.contains(banco)) {
            bancos.add(banco);
        }

        return this.bancos;
    }

    public List<Banco> deletarBanco(Banco banco) {
        if(bancos.contains(banco)) {
            this.bancos.remove(banco);
            System.out.println("Remoção do banco realizada com sucesso!");
        } else {
            System.out.println("Erro: Esse banco não existe na lista.");
        }
        return this.bancos;
    }

    public void mostrarUsuario() {
        System.out.println("Usuario: " + nome);
        System.out.println("Cpf: " + cpf);
        System.out.println("Email: " + email);
        System.out.println("Sexo: " + sexo);
    }
}
