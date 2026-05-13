package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class FrequenciaResponseDTO {
    private Long id;
    private Long matriculaTurmaId;
    private LocalDate dataAula;
    private Boolean presente;
    private String observacao;
    private String status;
}
