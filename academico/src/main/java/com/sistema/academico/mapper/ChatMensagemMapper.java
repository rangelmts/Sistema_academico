package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.ChatMensagemRequestDTO;
import com.sistema.academico.dto.response.ChatMensagemResponseDTO;
import com.sistema.academico.entity.ChatMensagem;
import com.sistema.academico.entity.ChatTurma;
import com.sistema.academico.entity.Usuario;

public class ChatMensagemMapper {

    public static ChatMensagem toEntity(ChatMensagemRequestDTO dto) {
        if (dto == null) return null;
        return ChatMensagem.builder()
                .chat(ChatTurma.builder().id(dto.getChatId()).build())
                .usuario(Usuario.builder().id(dto.getUsuarioId()).build())
                .mensagem(dto.getMensagem())
                .build();
    }

    public static ChatMensagemResponseDTO toDTO(ChatMensagem entity) {
        if (entity == null) return null;
        return ChatMensagemResponseDTO.builder()
                .id(entity.getId())
                .usuarioNome(entity.getUsuario() != null ? entity.getUsuario().getNome() : null)
                .mensagem(entity.getMensagem())
                .dataEnvio(entity.getDataEnvio())
                .status(entity.getStatus())
                .build();
    }
}
