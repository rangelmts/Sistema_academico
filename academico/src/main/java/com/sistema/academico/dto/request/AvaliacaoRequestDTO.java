package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class AvaliacaoRequestDTO {

    @NotNull(message = "A matrícula é obrigatória")
    private Long matriculaTurmaId;

    @NotNull(message = "A nota é obrigatória")
    private BigDecimal nota;

    private String descricao;
}
