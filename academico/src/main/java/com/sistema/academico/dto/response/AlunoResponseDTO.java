package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoResponseDTO {
    private Long id;
    private UsuarioResponseDTO usuario;
    private String cursoNome;
    private String matricula;
    private String status;
}
