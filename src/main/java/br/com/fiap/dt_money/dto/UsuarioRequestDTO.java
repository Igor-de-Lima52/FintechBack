package br.com.fiap.dt_money.dto;

import br.com.fiap.dt_money.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record UsuarioRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O CPF é obrigatório")
        String cpf,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        String senha,

        @NotNull(message = "O sexo é obrigatório")
        Usuario.Sexo sexo,

        @NotNull(message = "A data de nascimento é obrigatória")
        LocalDateTime dataNascimento
) {}