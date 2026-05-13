package com.sistema.academico.service;

import com.sistema.academico.dto.request.MensagemRequestDTO;
import com.sistema.academico.dto.response.MensagemResponseDTO;
import java.util.List;

public interface ChatService {
    MensagemResponseDTO enviarMensagem(MensagemRequestDTO dto);
    List<MensagemResponseDTO> listarPorTurma(Long turmaId);
}
