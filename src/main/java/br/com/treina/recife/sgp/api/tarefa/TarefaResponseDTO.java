package br.com.treina.recife.sgp.api.tarefa;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.PrioridadeTarefa;
import br.com.treina.recife.sgp.api.enums.StatusTarefa;
import br.com.treina.recife.sgp.api.projeto.ProjetoResponseDTO;
import br.com.treina.recife.sgp.api.usuario.UsuarioResponseDTO;

public record TarefaResponseDTO(

        Long id,
        String titulo,
        String descricao,
        LocalDate dataCriacao,
        LocalDate dataConclusao,
        PrioridadeTarefa prioridade,
        StatusTarefa status,
        ProjetoResponseDTO projeto,
        UsuarioResponseDTO usuario) {

}
