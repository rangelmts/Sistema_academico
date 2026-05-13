package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorResponseDTO {
    private Long id;
    private UsuarioResponseDTO usuario;
    private String matriculaSiape;
    private String status;
}
