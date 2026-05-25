package br.com.fiap.dt_money.service;

import br.com.fiap.dt_money.dto.BrasilApiBancoDTO;
import br.com.fiap.dt_money.model.Banco;
import br.com.fiap.dt_money.repository.BancoRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class BancoService {

    private final BancoRepository bancoRepository;
    private final RestClient restClient;

    public BancoService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
        this.restClient = RestClient.create("https://brasilapi.com.br/api");
    }

    public void sincronizarBancos() {
        List<BrasilApiBancoDTO> bancosDaApi = restClient.get()
                .uri("/banks/v1")
                .retrieve()
                .body(new ParameterizedTypeReference<List<BrasilApiBancoDTO>>() {});

        if (bancosDaApi == null) return;

        for (BrasilApiBancoDTO dto : bancosDaApi) {

            if (dto.fullName() == null || dto.fullName().isBlank()) {
                continue;
            }

            Banco novoBanco = new Banco();
            novoBanco.setNome(dto.fullName());

            bancoRepository.save(novoBanco);
        }
    }


    public Banco buscarBancoPorCodigo(Integer codigo) {
        return bancoRepository.findByCodigo(codigo);
    }

    public List<Banco> listarTodos() {
        return null;
    }
}