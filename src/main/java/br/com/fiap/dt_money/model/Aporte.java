package br.com.fiap.dt_money.model;

public class Aporte extends Despesa {
    private Investimento investimento;

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
