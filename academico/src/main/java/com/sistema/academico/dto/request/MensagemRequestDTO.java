package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MensagemRequestDTO {

    @NotNull(message = "A turma é obrigatória")
    private Long turmaId;

    @NotNull(message = "O autor é obrigatório")
    private Long autorId;

    @NotBlank(message = "O conteúdo não pode estar vazio")
    private String conteudo;
}
