package br.com.treina.recife.sgp.api.projeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/projetos")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> criarProjeto(@Valid @RequestBody ProjetoRequestDTO dto) {
        ProjetoResponseDTO projetoCriado = projetoService.criarProjeto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoCriado);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDTO>> listarProjetos() {
        return ResponseEntity.ok(projetoService.listarProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> obterDadosDoProjeto(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.obterDadosDoProjeto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> atualizarProjeto(@PathVariable Long id,
            @Valid @RequestBody ProjetoRequestDTO dto) {
        return ResponseEntity.ok(projetoService.atualizarProjeto(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
