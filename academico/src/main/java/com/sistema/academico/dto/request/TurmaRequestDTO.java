package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TurmaRequestDTO {

    @NotNull(message = "A disciplina é obrigatória")
    private Long disciplinaId;

    @NotNull(message = "O professor é obrigatório")
    private Long professorId;

    @NotNull(message = "O período letivo é obrigatório")
    private Long periodoLetivoId;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    private String codigoSuap;
}
