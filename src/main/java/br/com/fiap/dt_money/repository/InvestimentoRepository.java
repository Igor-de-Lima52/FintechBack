package br.com.fiap.dt_money.repository;

import br.com.fiap.dt_money.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvestimentoRepository extends JpaRepository<Investimento, UUID> {
}
