package br.com.fiap.dt_money.service;

import br.com.fiap.dt_money.dto.TransacaoRequestDTO;
import br.com.fiap.dt_money.model.Categoria;
import br.com.fiap.dt_money.model.Conta;
import br.com.fiap.dt_money.model.Transacao;
import br.com.fiap.dt_money.model.Usuario;
import br.com.fiap.dt_money.repository.CategoriaRepository;
import br.com.fiap.dt_money.repository.ContaRepository;
import br.com.fiap.dt_money.repository.TransacaoRepository;
import br.com.fiap.dt_money.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ContaRepository contaRepository;

    public TransacaoService(TransacaoRepository transacaoRepository,
                            CategoriaRepository categoriaRepository,
                            UsuarioRepository usuarioRepository,
                            ContaRepository contaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.categoriaRepository = categoriaRepository;
        this.usuarioRepository = usuarioRepository;
        this.contaRepository = contaRepository;
    }

    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }

    public List<Transacao> listarPorConta(UUID contaId) {
        return transacaoRepository.findByContaId(contaId);
    }

    public Transacao buscarPorId(UUID id) {
        return transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    public Transacao criar(TransacaoRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Conta conta = contaRepository.findById(dto.contaId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        Transacao novaTransacao = new Transacao(dto.nome(), dto.descricao(), dto.valor(), categoria, usuario, conta);
        return transacaoRepository.save(novaTransacao);
    }

    public Transacao atualizar(UUID id, TransacaoRequestDTO dto) {
        Transacao transacaoExistente = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Conta conta = contaRepository.findById(dto.contaId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        transacaoExistente.setNome(dto.nome());
        transacaoExistente.setDescricao(dto.descricao());
        transacaoExistente.setValor(dto.valor());
        transacaoExistente.setCategoria(categoria);
        transacaoExistente.setUsuario(usuario);
        transacaoExistente.setConta(conta);

        return transacaoRepository.save(transacaoExistente);
    }

    public void deletar(UUID id) {
        Transacao transacaoExistente = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        transacaoRepository.delete(transacaoExistente);
    }
}
