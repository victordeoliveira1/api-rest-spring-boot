package br.com.treina.recife.sgp.api.projeto;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.StatusProjeto;
import br.com.treina.recife.sgp.api.usuario.UsuarioResponseDTO;

public record ProjetoResponseDTO(
        Long id,
        String nome,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataConclusao,
        Long diasDecorridos,
        StatusProjeto status,
        UsuarioResponseDTO responsavel) {

}
