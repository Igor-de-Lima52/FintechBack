package br.com.fiap.dt_money.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(

        @NotBlank(message = "O nome da categoria é obrigatório")
        String nome,

        @NotBlank(message = "O tipo da categoria é obrigatório")
        String tipo
) {}
