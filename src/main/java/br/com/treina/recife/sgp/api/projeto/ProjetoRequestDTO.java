package br.com.treina.recife.sgp.api.projeto;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.StatusProjeto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjetoRequestDTO(
    @NotBlank(message = "O nome é obrigatório")
    String nome,
    String descricao,
    @NotNull(message = "A data de inicial é obrigatória.")
    LocalDate dataInicio,
    LocalDate dataConclusao,
    @NotNull(message = "O Status é obrigatório.")
    StatusProjeto status,
    @NotNull(message = "O Id do responsável é obrigatório.")
    Long responsavelId
) {
    
}
