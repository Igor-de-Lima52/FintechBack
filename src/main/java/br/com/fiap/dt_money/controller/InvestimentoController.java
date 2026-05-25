package br.com.fiap.dt_money.controller;

import br.com.fiap.dt_money.dto.InvestimentoRequestDTO;
import br.com.fiap.dt_money.model.Investimento;
import br.com.fiap.dt_money.service.InvestimentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/investimentos")
public class InvestimentoController {

    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @GetMapping
    public ResponseEntity<List<Investimento>> listarTodos() {
        return ResponseEntity.ok(investimentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investimento> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(investimentoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Investimento> criar(@RequestBody @Valid InvestimentoRequestDTO dto) {
        Investimento investimentoCriado = investimentoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(investimentoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investimento> atualizar(@PathVariable UUID id, @RequestBody @Valid InvestimentoRequestDTO dto) {
        Investimento investimentoAtualizado = investimentoService.atualizar(id, dto);
        return ResponseEntity.ok(investimentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        investimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
