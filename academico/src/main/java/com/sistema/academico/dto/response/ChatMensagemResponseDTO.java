package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ChatMensagemResponseDTO {
    private Long id;
    private String usuarioNome;
    private String mensagem;
    private LocalDateTime dataEnvio;
    private String status;
}
