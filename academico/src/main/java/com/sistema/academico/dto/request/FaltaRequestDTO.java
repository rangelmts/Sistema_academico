package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class FaltaRequestDTO {

    @NotNull(message = "A matrícula é obrigatória")
    private Long matriculaTurmaId;

    @NotNull(message = "A data da aula é obrigatória")
    private LocalDate dataAula;

    private Integer quantidade;

    private String justificativa;

    private String codigoSuap;
}
