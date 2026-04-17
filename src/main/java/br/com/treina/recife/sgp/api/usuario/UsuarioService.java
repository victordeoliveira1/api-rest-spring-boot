package br.com.treina.recife.sgp.api.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treina.recife.sgp.api.common.exception.RecursoNaoEncontradoException;
import br.com.treina.recife.sgp.api.common.exception.RegraDeNegociosException;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // POST
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCpf(dto.cpf());
        if (usuarioOpt.isPresent()) {
            throw new RegraDeNegociosException("Já existe um usuário cadastrado com o CPF: " + dto.cpf());
        }
        usuarioOpt = usuarioRepository.findByEmail(dto.email());
        if (usuarioOpt.isPresent()) {
            throw new RegraDeNegociosException("Já existe um usuário cadastrado com o email: " + dto.email());
        }
        Usuario usuario = UsuarioMapper.toEntity(dto);
        return UsuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    // GET
    // TODO: PESQUISAR MAIS SOBRE O STREAM E O TO LIST
    public List<UsuarioResponseDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    public UsuarioResponseDTO obterDadosDoUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id));
        return UsuarioMapper.toDTO(usuario);
    }

    // PUT
    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id));

        usuario.setNome(dto.nome());
        usuario.setCpf(dto.cpf());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setStatus(dto.status());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(usuarioAtualizado);
    }

    // DELETE
    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id));
        usuarioRepository.delete(usuario);
    }

}
