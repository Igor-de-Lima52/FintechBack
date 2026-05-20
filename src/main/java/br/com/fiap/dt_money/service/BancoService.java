package br.com.fiap.dt_money.service;

import br.com.fiap.dt_money.model.Banco;
import br.com.fiap.dt_money.model.Conta;
import br.com.fiap.dt_money.repository.BancoRepository;
import br.com.fiap.dt_money.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;
    private ContaRepository contaRepository;

    public Banco inativarBanco(UUID id){
        Banco banco = bancoRepository.findById(id).orElseThrow();
        banco.inativarBanco();
        return bancoRepository.save(banco);
    }

public Banco adicionarConta(UUID bancoId, UUID contaId) {

        Banco banco = bancoRepository.findById(bancoId).orElseThrow();

        Conta conta = contaRepository.findById(contaId).orElseThrow();

        banco.adicionarConta(conta);

        return bancoRepository.save(banco);
    }

    public Banco deletarConta(UUID bancoId, UUID contaId) {

        Banco banco = bancoRepository.findById(bancoId).orElseThrow();

        Conta conta = contaRepository.findById(contaId).orElseThrow();

        banco.deletarConta(conta);

        return bancoRepository.save(banco);
    }
}
