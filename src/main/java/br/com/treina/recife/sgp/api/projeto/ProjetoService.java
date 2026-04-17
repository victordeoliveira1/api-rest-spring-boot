package br.com.treina.recife.sgp.api.projeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.treina.recife.sgp.api.common.exception.RecursoNaoEncontradoException;
import br.com.treina.recife.sgp.api.usuario.Usuario;
import br.com.treina.recife.sgp.api.usuario.UsuarioRepository;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    // POST
    @Transactional
    public ProjetoResponseDTO criarProjeto(ProjetoRequestDTO dto) {
        Usuario responsavel = usuarioRepository.findById(dto.responsavelId())
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Não foi encontrado um usuário com ID: " + dto.responsavelId()));
        Projeto projeto = ProjetoMapper.toEntity(dto);
        projeto.setResponsavel(responsavel);
        return ProjetoMapper.toDTO(projetoRepository.save(projeto));

    }

    // GET
    @Transactional(readOnly = true)
    public List<ProjetoResponseDTO> listarProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        return projetos.stream()
                .map(ProjetoMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProjetoResponseDTO obterDadosDoProjeto(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Não foi encontrado projeto com ID: " + id));
        return ProjetoMapper.toDTO(projeto);
    }

    // PUT
    @Transactional
    public ProjetoResponseDTO atualizarProjeto(Long id, ProjetoRequestDTO dto) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Não foi encontrado projeto com ID: " + id));

        Usuario usuario = usuarioRepository.findById(dto.responsavelId())
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Não foi encontrado um usuário com o ID: " + dto.responsavelId()));

        projeto.setNome(dto.nome());
        projeto.setDescricao(dto.descricao());
        projeto.setDataInicio(dto.dataInicio());
        projeto.setDataConclusao(dto.dataConclusao());
        projeto.setStatus(dto.status());
        projeto.setResponsavel(usuario);
        return ProjetoMapper.toDTO(projetoRepository.save(projeto));
    }

    // DELETE
    @Transactional
    public void deletarProjeto(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Não foi encontrado um projeto com o ID: " + id));
        projetoRepository.delete(projeto);
    }
}
