package br.com.fiap.dt_money.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "t_fin_investimento")
public class Investimento extends Transacao {

    @Column(name = "tipo_investimento", length = 100)
    private String tipoInvestimento;

    public Investimento(String nome, String descricao, double valor, Categoria categoria, Usuario usuario, Conta conta, String tipoInvestimento) {
        super(nome, descricao, valor, categoria, usuario, conta);
        this.tipoInvestimento = tipoInvestimento;
    }

    public Investimento() {
        super();
    }
}
