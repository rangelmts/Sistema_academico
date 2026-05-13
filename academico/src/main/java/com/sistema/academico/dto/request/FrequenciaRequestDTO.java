package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class FrequenciaRequestDTO {

    @NotNull(message = "A matrícula é obrigatória")
    private Long matriculaTurmaId;

    @NotNull(message = "A data da aula é obrigatória")
    private LocalDate dataAula;

    @NotNull(message = "O status de presença é obrigatório")
    private Boolean presente;

    private String observacao;
}
