package com.sistema.academico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChatMensagemRequestDTO {

    @NotNull(message = "O chat é obrigatório")
    private Long chatId;

    @NotNull(message = "O usuário é obrigatório")
    private Long usuarioId;

    @NotBlank(message = "A mensagem não pode estar vazia")
    private String mensagem;
}
