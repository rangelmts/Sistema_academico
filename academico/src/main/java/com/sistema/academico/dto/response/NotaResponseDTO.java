package com.sistema.academico.dto.response;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class NotaResponseDTO {
    private Long id;
    private Long matriculaTurmaId;
    private String descricao;
    private BigDecimal valor;
    private BigDecimal peso;
    private LocalDate dataAvaliacao;
    private String codigoSuap;
    private String status;
}
