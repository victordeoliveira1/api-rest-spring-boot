package br.com.treina.recife.sgp.api.common.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponseDTO {
    
    private LocalDateTime timeStamp;
    private Integer status;    
    private String erro;
    private String mensagem;
    private String caminho;
}
