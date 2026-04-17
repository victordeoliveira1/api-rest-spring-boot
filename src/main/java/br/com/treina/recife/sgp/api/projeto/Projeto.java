package br.com.treina.recife.sgp.api.projeto;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.StatusProjeto;
import br.com.treina.recife.sgp.api.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TB_PROJETOS")
public class Projeto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;
    
    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column
    private LocalDate dataConclusao;

    @Column(nullable = false)
    private StatusProjeto status;

    @ManyToOne
    @JoinColumn(name = "usuario_resp_id", nullable = false)
    private Usuario responsavel;
}
