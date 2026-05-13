package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class AvaliacaoResponseDTO {
    private Long id;
    private Long matriculaTurmaId;
    private BigDecimal nota;
    private String descricao;
    private LocalDateTime dataLancamento;
    private String status;
}
