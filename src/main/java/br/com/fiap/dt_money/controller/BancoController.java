package br.com.fiap.dt_money.controller;

import br.com.fiap.dt_money.model.Banco;
import br.com.fiap.dt_money.service.BancoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/bancos")
public class BancoController {

    private final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @GetMapping
    public ResponseEntity<List<Banco>> listarBancos() {
        return ResponseEntity.ok(bancoService.listarTodos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Banco> buscarPorCodigo(@PathVariable Integer codigo) {
        return ResponseEntity.ok(bancoService.buscarBancoPorCodigo(codigo));
    }

    @PostMapping("/sincronizar")
    public ResponseEntity<String> sincronizarDaApiExterna() {
        bancoService.sincronizarBancos();
        return ResponseEntity.ok("Bancos sincronizados com a Brasil API com sucesso!");
    }
}
