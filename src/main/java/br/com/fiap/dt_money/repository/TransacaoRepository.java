package br.com.fiap.dt_money.repository;

import br.com.fiap.dt_money.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    List<Transacao> findByContaId(UUID contaId);
}
