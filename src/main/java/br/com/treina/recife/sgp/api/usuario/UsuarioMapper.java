package br.com.treina.recife.sgp.api.usuario;

import java.time.LocalDate;
import java.time.Period;

public class UsuarioMapper {

    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        int idade = 0;
        if (usuario.getDataNascimento() != null) {
            idade = Period.between(usuario.getDataNascimento(), LocalDate.now()).getYears();
        }

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getDataNascimento(),
                idade,
                usuario.getStatus());
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setCpf(dto.cpf());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setStatus(dto.status());
        return usuario;
    }

}
