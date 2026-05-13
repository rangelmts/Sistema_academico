package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String perfil;
    private String status;
    private LocalDateTime dataCadastro;
}
