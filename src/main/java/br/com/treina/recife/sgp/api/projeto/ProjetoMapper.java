package br.com.treina.recife.sgp.api.projeto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.treina.recife.sgp.api.usuario.UsuarioMapper;

public class ProjetoMapper {

    public static ProjetoResponseDTO toDTO(Projeto projeto) {
        Long diasDecorridos = ChronoUnit.DAYS.between(
                projeto.getDataInicio(),
                LocalDate.now());
        return new ProjetoResponseDTO(
                projeto.getId(),
                projeto.getNome(),
                projeto.getDescricao(),
                projeto.getDataInicio(),
                projeto.getDataConclusao(),
                diasDecorridos,
                projeto.getStatus(),
                UsuarioMapper.toDTO(projeto.getResponsavel()));
    }

    public static Projeto toEntity(ProjetoRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        Projeto projeto = new Projeto();
        projeto.setNome(dto.nome());
        projeto.setDescricao(dto.descricao());
        projeto.setDataInicio(dto.dataInicio());
        projeto.setDataConclusao(dto.dataConclusao());
        projeto.setStatus(dto.status());
        return projeto;
    }

}
