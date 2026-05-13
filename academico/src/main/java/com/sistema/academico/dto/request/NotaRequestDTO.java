package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class NotaRequestDTO {

    @NotNull(message = "A matrícula é obrigatória")
    private Long matriculaTurmaId;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "O valor da nota é obrigatório")
    private BigDecimal valor;

    private BigDecimal peso;

    private LocalDate dataAvaliacao;

    private String codigoSuap;
}
