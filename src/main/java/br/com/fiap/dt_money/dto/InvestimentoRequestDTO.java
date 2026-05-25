package br.com.fiap.dt_money.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record InvestimentoRequestDTO(

        @NotBlank(message = "O nome do investimento é obrigatório")
        String nome,

        String descricao,

        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser positivo")
        Double valor,

        @NotNull(message = "O ID da categoria é obrigatório")
        UUID categoriaId,

        @NotNull(message = "O ID do usuário é obrigatório")
        UUID usuarioId,

        @NotNull(message = "O ID da conta é obrigatório")
        UUID contaId,

        @NotBlank(message = "O tipo de investimento é obrigatório")
        String tipoInvestimento
) {}
