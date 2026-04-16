package br.com.fiap.model;

public class Investimento extends Transacao {
    public Investimento(String nome, String descricao, double valor, Categoria categoria) {
        super(nome, descricao, valor, categoria);
    }

    public Investimento() {
        super();
    }
}
