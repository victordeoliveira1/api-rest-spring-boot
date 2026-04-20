package br.com.treina.recife.sgp.api.tarefa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.treina.recife.sgp.api.common.exception.RecursoNaoEncontradoException;
import br.com.treina.recife.sgp.api.projeto.Projeto;
import br.com.treina.recife.sgp.api.projeto.ProjetoRepository;
import br.com.treina.recife.sgp.api.usuario.Usuario;
import br.com.treina.recife.sgp.api.usuario.UsuarioRepository;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;
    @Autowired
    ProjetoRepository projetoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    // POST
    @Transactional
    public TarefaResponseDTO criarTarefa(TarefaRequestDTO dto) {
        Projeto projeto = projetoRepository.findById(dto.projetoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Não foi encontrado um projeto com o ID: " + dto.projetoId()));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(
                () -> new RecursoNaoEncontradoException("Não foi encontrado um usuário com ID: " + dto.usuarioId()));

        Tarefa tarefa = TarefaMapper.toEntity(dto);
        tarefa.setProjeto(projeto);
        tarefa.setUsuario(usuario);
        return TarefaMapper.toDTO(tarefaRepository.save(tarefa));
    }

    // GET
    @Transactional(readOnly = true)
    public List<TarefaResponseDTO> listarTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(TarefaMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public TarefaResponseDTO obterDadosDaTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(
                        () -> new RecursoNaoEncontradoException("Não foi encontrado nenhuma tarefa com ID: " + id));

        return TarefaMapper.toDTO(tarefa);
    }

    // PUT
    @Transactional
    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO dto) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(
                        () -> new RecursoNaoEncontradoException("Não foi encontrado nenhuma tarefa com ID: " + id));

        Projeto projeto = projetoRepository.findById(dto.projetoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Não foi encontrado nenhum projeto com ID: " + dto.projetoId()));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Não foi encontrando nenhum usuário com ID: " + dto.usuarioId()));

        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setDataCriacao(dto.dataCriacao());
        tarefa.setDataConclusao(dto.dataConclusao());
        tarefa.setPrioridade(dto.prioridade());
        tarefa.setStatus(dto.status());
        tarefa.setProjeto(projeto);
        tarefa.setUsuario(usuario);
        return TarefaMapper.toDTO(tarefaRepository.save(tarefa));
    }

    // DELETE
    @Transactional
    public void deletarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Não foi encontrado um projeto com ID: " + id));
        tarefaRepository.delete(tarefa);
    }
}
