package com.sistema.academico.service.impl;

import com.sistema.academico.dto.request.ChatMensagemRequestDTO;
import com.sistema.academico.dto.response.ChatMensagemResponseDTO;
import com.sistema.academico.entity.ChatMensagem;
import com.sistema.academico.mapper.ChatMensagemMapper;
import com.sistema.academico.repository.ChatMensagemRepository;
import com.sistema.academico.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMensagemRepository chatMensagemRepository;

    @Override
    @Transactional
    public ChatMensagemResponseDTO enviarMensagem(ChatMensagemRequestDTO dto) {
        ChatMensagem entity = ChatMensagemMapper.toEntity(dto);
        return ChatMensagemMapper.toDTO(chatMensagemRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChatMensagemResponseDTO> listarPorChat(Long chatId) {
        return chatMensagemRepository.findByChatIdOrderByDataEnvioAsc(chatId).stream()
                .map(ChatMensagemMapper::toDTO)
                .collect(Collectors.toList());
    }
}
