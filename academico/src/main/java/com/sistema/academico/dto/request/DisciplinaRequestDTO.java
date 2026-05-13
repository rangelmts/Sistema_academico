package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DisciplinaRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private String codigo;

    @Positive(message = "A carga horária deve ser positiva")
    private Integer cargaHoraria;
}
