package br.com.treina.recife.sgp.api.tarefa;

import java.time.LocalDate;

import br.com.treina.recife.sgp.api.enums.PrioridadeTarefa;
import br.com.treina.recife.sgp.api.enums.StatusTarefa;
import br.com.treina.recife.sgp.api.projeto.Projeto;
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
@Entity(name = "TB_TAREFAS")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataCriacao;

    @Column
    private LocalDate dataConclusao;

    @Column(nullable = false)
    private PrioridadeTarefa prioridade;
    
    @Column(nullable = false)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
