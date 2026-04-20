package br.com.treina.recife.sgp.api.tarefa;

import br.com.treina.recife.sgp.api.projeto.ProjetoMapper;
import br.com.treina.recife.sgp.api.usuario.UsuarioMapper;

public class TarefaMapper {

    public static TarefaResponseDTO toDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getDataCriacao(),
                tarefa.getDataConclusao(),
                tarefa.getPrioridade(),
                tarefa.getStatus(),
                ProjetoMapper.toDTO(tarefa.getProjeto()),
                UsuarioMapper.toDTO(tarefa.getUsuario()));
    }

    public static Tarefa toEntity(TarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setDataCriacao(dto.dataCriacao());
        tarefa.setDataConclusao(dto.dataConclusao());
        tarefa.setPrioridade(dto.prioridade());
        tarefa.setStatus(dto.status());
        return tarefa;
    }
}
