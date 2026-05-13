package com.sistema.academico.service;

import com.sistema.academico.dto.request.ChatMensagemRequestDTO;
import com.sistema.academico.dto.response.ChatMensagemResponseDTO;
import java.util.List;

public interface ChatService {
    ChatMensagemResponseDTO enviarMensagem(ChatMensagemRequestDTO dto);
    List<ChatMensagemResponseDTO> listarPorChat(Long chatId);
}
