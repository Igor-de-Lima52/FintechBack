package br.com.fiap.dt_money.service;

import br.com.fiap.dt_money.dto.CategoriaRequestDTO;
import br.com.fiap.dt_money.model.Categoria;
import br.com.fiap.dt_money.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(UUID id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public Categoria criar(CategoriaRequestDTO dto) {
        Categoria novaCategoria = new Categoria(dto.nome(), dto.tipo());
        return categoriaRepository.save(novaCategoria);
    }

    public Categoria atualizar(UUID id, CategoriaRequestDTO dto) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoriaExistente.setNome(dto.nome());
        categoriaExistente.setTipo(dto.tipo());

        return categoriaRepository.save(categoriaExistente);
    }

    public void deletar(UUID id) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoriaRepository.delete(categoriaExistente);
    }
}
