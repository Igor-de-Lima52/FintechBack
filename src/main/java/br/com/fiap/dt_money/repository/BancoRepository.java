package br.com.fiap.dt_money.repository;

import br.com.fiap.dt_money.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BancoRepository extends JpaRepository<Banco, UUID> {
}
