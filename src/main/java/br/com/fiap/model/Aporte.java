package br.com.fiap.model;

public class Aporte extends Despesa {
    private Investimento investimento;

    public Aporte(String nome, String descricao, double valor, Categoria categoria) {
        super(nome, descricao, valor, categoria);
    }

    public Aporte() {
        super();
    }

    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

}
