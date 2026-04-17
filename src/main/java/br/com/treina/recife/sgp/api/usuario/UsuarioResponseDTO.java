package br.com.treina.recife.sgp.api.usuario;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.StatusUsuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String cpf,
        String email,
        LocalDate dataNascimento,
        Integer idade,
        StatusUsuario status) {
}