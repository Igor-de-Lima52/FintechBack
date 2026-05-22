package br.com.fiap.dt_money.service;

import br.com.fiap.dt_money.dto.ContaRequestDTO;
import br.com.fiap.dt_money.model.Banco;
import br.com.fiap.dt_money.model.Conta;
import br.com.fiap.dt_money.model.Usuario;
import br.com.fiap.dt_money.repository.BancoRepository;
import br.com.fiap.dt_money.repository.ContaRepository;
import br.com.fiap.dt_money.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final UsuarioRepository usuarioRepository;
    private final BancoRepository bancoRepository;

    public ContaService(ContaRepository contaRepository, UsuarioRepository usuarioRepository, BancoRepository bancoRepository) {
        this.contaRepository = contaRepository;
        this.usuarioRepository = usuarioRepository;
        this.bancoRepository = bancoRepository;
    }

    public Conta criar(ContaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Banco banco = bancoRepository.findById(dto.bancoId()).orElseThrow(() -> new RuntimeException("Banco não encontrado"));

        Conta novaConta = new Conta(dto.nome(), usuario, banco);

        return contaRepository.save(novaConta);
    }

    public Conta atualizar(UUID id, ContaRequestDTO dto) {
        Conta contaExistente = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Banco banco = bancoRepository.findById(dto.bancoId()).orElseThrow(() -> new RuntimeException("Banco não encontrado"));

        contaExistente.setNome(dto.nome());
        contaExistente.setUsuario(usuario);
        contaExistente.setBanco(banco);

        return contaRepository.save(contaExistente);
    }

    public Conta inativar(UUID id) {
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        conta.inativarConta();
        return contaRepository.save(conta);
    }

    // Retorna todas as contas vinculadas a um ID de usuário específico
    public List<Conta> listarPorUsuario(UUID usuarioId) {
        return contaRepository.findByUsuarioId(usuarioId);
    }
}