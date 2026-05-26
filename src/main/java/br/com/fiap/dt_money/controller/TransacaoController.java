package br.com.fiap.dt_money.controller;

import br.com.fiap.dt_money.dto.TransacaoRequestDTO;
import br.com.fiap.dt_money.model.Transacao;
import br.com.fiap.dt_money.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTodas() {
        return ResponseEntity.ok(transacaoService.listarTodas());
    }

    @GetMapping("/conta/{contaId}")
    public ResponseEntity<List<Transacao>> listarPorConta(@PathVariable UUID contaId) {
        return ResponseEntity.ok(transacaoService.listarPorConta(contaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(transacaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Transacao> criar(@RequestBody @Valid TransacaoRequestDTO dto) {
        Transacao transacaoCriada = transacaoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable UUID id, @RequestBody @Valid TransacaoRequestDTO dto) {
        Transacao transacaoAtualizada = transacaoService.atualizar(id, dto);
        return ResponseEntity.ok(transacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        transacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
