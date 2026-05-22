package br.com.fiap.dt_money.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record ContaRequestDTO(
        @NotBlank(message = "O nome da conta é obrigatório")
        String nome,

        @NotNull(message = "O ID do usuário é obrigatório")
        UUID usuarioId,

        @NotNull(message = "O ID do banco é obrigatório")
        UUID bancoId
) {}