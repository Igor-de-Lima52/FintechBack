package br.com.fiap.model;

public class Despesa extends Transacao {
    public Despesa(String nome, String descricao, double valor, Categoria categoria) {
        super(nome, descricao, valor, categoria);
    }
    public Despesa() { super(); }
}
