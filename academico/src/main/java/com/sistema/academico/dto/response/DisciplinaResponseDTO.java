package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisciplinaResponseDTO {
    private Long id;
    private String nome;
    private String codigo;
    private Integer cargaHoraria;
    private String status;
}
