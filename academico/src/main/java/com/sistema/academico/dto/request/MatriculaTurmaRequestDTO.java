package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MatriculaTurmaRequestDTO {

    @NotNull(message = "O aluno é obrigatório")
    private Long alunoId;

    @NotNull(message = "A turma é obrigatória")
    private Long turmaId;
}
