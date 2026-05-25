package br.com.fiap.dt_money.service;

import br.com.fiap.dt_money.dto.InvestimentoRequestDTO;
import br.com.fiap.dt_money.model.Categoria;
import br.com.fiap.dt_money.model.Conta;
import br.com.fiap.dt_money.model.Investimento;
import br.com.fiap.dt_money.model.Usuario;
import br.com.fiap.dt_money.repository.CategoriaRepository;
import br.com.fiap.dt_money.repository.ContaRepository;
import br.com.fiap.dt_money.repository.InvestimentoRepository;
import br.com.fiap.dt_money.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvestimentoService {

    private final InvestimentoRepository investimentoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ContaRepository contaRepository;

    public InvestimentoService(InvestimentoRepository investimentoRepository,
                               CategoriaRepository categoriaRepository,
                               UsuarioRepository usuarioRepository,
                               ContaRepository contaRepository) {
        this.investimentoRepository = investimentoRepository;
        this.categoriaRepository = categoriaRepository;
        this.usuarioRepository = usuarioRepository;
        this.contaRepository = contaRepository;
    }

    public List<Investimento> listarTodos() {
        return investimentoRepository.findAll();
    }

    public Investimento buscarPorId(UUID id) {
        return investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado"));
    }

    public Investimento criar(InvestimentoRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Conta conta = contaRepository.findById(dto.contaId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        Investimento novoInvestimento = new Investimento(dto.nome(), dto.descricao(), dto.valor(), categoria, usuario, conta, dto.tipoInvestimento());
        return investimentoRepository.save(novoInvestimento);
    }

    public Investimento atualizar(UUID id, InvestimentoRequestDTO dto) {
        Investimento investimentoExistente = investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado"));

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Conta conta = contaRepository.findById(dto.contaId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        investimentoExistente.setNome(dto.nome());
        investimentoExistente.setDescricao(dto.descricao());
        investimentoExistente.setValor(dto.valor());
        investimentoExistente.setCategoria(categoria);
        investimentoExistente.setUsuario(usuario);
        investimentoExistente.setConta(conta);
        investimentoExistente.setTipoInvestimento(dto.tipoInvestimento());

        return investimentoRepository.save(investimentoExistente);
    }

    public void deletar(UUID id) {
        Investimento investimentoExistente = investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado"));

        investimentoRepository.delete(investimentoExistente);
    }
}
