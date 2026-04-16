package br.com.fiap.model;

public class Receita extends Transacao {
    public Receita(String nome, String descricao, double valor, Categoria categoria) {
        super(nome, descricao, valor, categoria);
    }
    public Receita() { super(); }
}

