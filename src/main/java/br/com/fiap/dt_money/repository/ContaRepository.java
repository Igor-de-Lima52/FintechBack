package br.com.fiap.dt_money.repository;

import br.com.fiap.dt_money.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
    List<Conta> findByUsuarioId(UUID usuarioId);
}
