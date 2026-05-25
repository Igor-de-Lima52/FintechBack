package br.com.fiap.dt_money.controller;

import br.com.fiap.dt_money.dto.LoginRequestDTO;
import br.com.fiap.dt_money.dto.UsuarioRequestDTO;
import br.com.fiap.dt_money.model.Usuario;
import br.com.fiap.dt_money.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody @Valid UsuarioRequestDTO dto) {
        Usuario usuarioCriado = usuarioService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(
            @PathVariable UUID id,
            @RequestBody @Valid UsuarioRequestDTO dto) {

        Usuario usuarioAtualizado = usuarioService.editar(id, dto);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDTO dto) {
        Usuario usuarioLogado = usuarioService.autenticar(dto);

        return ResponseEntity.ok("Login realizado com sucesso! Bem-vindo(a), " + usuarioLogado.getNome());
    }

    @PostMapping("/{usuarioId}/bancos/{bancoId}")
    public ResponseEntity<Usuario> adicionarBanco(@PathVariable UUID usuarioId, @PathVariable UUID bancoId) {
        Usuario usuarioAtualizado = usuarioService.adicionarBancoAoUsuario(usuarioId, bancoId);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{usuarioId}/bancos/{bancoId}")
    public ResponseEntity<Usuario> removerBanco(@PathVariable UUID usuarioId, @PathVariable UUID bancoId) {
        Usuario usuarioAtualizado = usuarioService.removerBancoDoUsuario(usuarioId, bancoId);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}