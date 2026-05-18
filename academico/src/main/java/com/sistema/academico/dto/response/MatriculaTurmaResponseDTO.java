package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class MatriculaTurmaResponseDTO {
    private Long id;
    private AlunoResponseDTO aluno;
    private TurmaResponseDTO turma;
    private LocalDate dataMatricula;
    private String status;
}
