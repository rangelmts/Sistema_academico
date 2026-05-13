package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class MensagemResponseDTO {
    private Long id;
    private String autorNome;
    private String conteudo;
    private LocalDateTime dataEnvio;
}
