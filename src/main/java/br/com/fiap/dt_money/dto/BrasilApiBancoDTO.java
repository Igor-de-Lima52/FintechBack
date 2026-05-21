package br.com.fiap.dt_money.dto;

public record BrasilApiBancoDTO(
        String ispb,
        String name,
        Integer code,
        String fullName
) {}