package br.com.treina.recife.sgp.api.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treina.recife.sgp.api.common.exception.RecursoNaoEncontradoException;
import br.com.treina.recife.sgp.api.usuario.Usuario;
import br.com.treina.recife.sgp.api.usuario.UsuarioRepository;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;

    UsuarioRepository usuarioRepository;

    // POST
    public ProjetoResponseDTO criarProjeto(ProjetoRequestDTO dto) {
        Usuario responsavel = usuarioRepository.findById(dto.responsavelId())
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Não foi encontrado um usuário com ID: " + dto.responsavelId()));
        Projeto projeto = ProjetoMapper.toEntity(dto);
        projeto.setResponsavel(responsavel);
        return ProjetoMapper.toDTO(projeto);

    }
    // GET

    // PUT

    // DELETE

}
