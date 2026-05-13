package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TurmaResponseDTO {
    private Long id;
    private DisciplinaResponseDTO disciplina;
    private ProfessorResponseDTO professor;
    private String periodoLetivoDescricao;
    private String descricao;
    private String codigoSuap;
    private String status;
}
