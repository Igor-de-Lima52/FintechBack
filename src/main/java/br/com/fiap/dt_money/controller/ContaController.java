package br.com.fiap.dt_money.controller;

import br.com.fiap.dt_money.dto.ContaRequestDTO;
import br.com.fiap.dt_money.model.Conta;
import br.com.fiap.dt_money.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<Conta> criar(@RequestBody @Valid ContaRequestDTO dto) {
        Conta contaCriada = contaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizar(@PathVariable UUID id, @RequestBody @Valid ContaRequestDTO dto) {
        Conta contaAtualizada = contaService.atualizar(id, dto);
        return ResponseEntity.ok(contaAtualizada);
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Conta> inativar(@PathVariable UUID id) {
        Conta contaInativada = contaService.inativar(id);
        return ResponseEntity.ok(contaInativada);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Conta>> listarPorUsuario(@PathVariable UUID usuarioId) {
        List<Conta> contas = contaService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(contas);
    }
}