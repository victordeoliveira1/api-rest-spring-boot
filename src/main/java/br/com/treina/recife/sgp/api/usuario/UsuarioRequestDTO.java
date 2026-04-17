package br.com.treina.recife.sgp.api.usuario;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.StatusUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(
        @NotBlank(message = "O nome é obrigatório.")
        @Size(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres.")
        String nome,

        @NotBlank(message = "O CPF é obrigatório.")
        @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 caracteres.")
        String cpf,

        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "Email inválido")
        @Size(max = 254, message = "O email deve conter no máximo 254 caracteres.")
        String email,

        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 6, max = 19, message = "A senha deve conter entre 6 e 19 caracteres.")
        String senha,

        @NotNull(message = "A data de nascimento é obrigatória.")
        @Past(message = "A data de nascimento deve estar no passado")
        LocalDate dataNascimento,

        @NotNull(message = "O status é obrigatório.")
        StatusUsuario status
    ) {

}
