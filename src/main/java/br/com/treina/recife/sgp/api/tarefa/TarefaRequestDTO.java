package br.com.treina.recife.sgp.api.tarefa;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.PrioridadeTarefa;
import br.com.treina.recife.sgp.api.enums.StatusTarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TarefaRequestDTO(

    @NotBlank(message = "O título da tarefa é obrigatório.")
    String titulo,
    String descricao,
    @NotNull(message = "Data incial obrigatória.")
    LocalDate dataCriacao,
    LocalDate dataConclusao,
    @NotNull(message = "A prioridade da tarefa é obrigatória.")
    PrioridadeTarefa prioridade,
    @NotNull(message = "O status da tarefa é obrigatória.")
    StatusTarefa status,
    @NotNull(message = "O Id do projeto é obrigatório.")
    Long projetoId,
    @NotNull(message = "O Id do usuário é obrigatório.")
    Long usuarioId
) {
    
}
