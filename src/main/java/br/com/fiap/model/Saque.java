package br.com.fiap.model;

import java.util.UUID;

public class Saque extends Receita {
    private Investimento investimento;

    public Saque(String nome, String descricao, double valor, Categoria categoria) {
        super(nome, descricao, valor, categoria);
    }

    public Saque() {
        super();
    }

    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }
}
