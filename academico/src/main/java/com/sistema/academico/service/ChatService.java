package com.sistema.academico.service;

import com.sistema.academico.dto.request.MensagemRequestDTO;
import com.sistema.academico.dto.response.MensagemResponseDTO;
import java.util.List;

/**
 * Serviço responsável pela orquestração do chat das turmas.
 * Cada turma possui um canal isolado de mensagens.
 */
public interface ChatService {
    MensagemResponseDTO enviarMensagem(MensagemRequestDTO dto);
    List<MensagemResponseDTO> listarPorTurma(Long turmaId);
}
