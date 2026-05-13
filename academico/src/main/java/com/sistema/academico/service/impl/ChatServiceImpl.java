package com.sistema.academico.service.impl;

import com.sistema.academico.dto.request.MensagemRequestDTO;
import com.sistema.academico.dto.response.MensagemResponseDTO;
import com.sistema.academico.entity.Mensagem;
import com.sistema.academico.mapper.MensagemMapper;
import com.sistema.academico.repository.MensagemRepository;
import com.sistema.academico.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final MensagemRepository mensagemRepository;

    @Override
    @Transactional
    public MensagemResponseDTO enviarMensagem(MensagemRequestDTO dto) {
        Mensagem entity = MensagemMapper.toEntity(dto);
        return MensagemMapper.toDTO(mensagemRepository.save(entity));
    }

    @Override
    public List<MensagemResponseDTO> listarPorTurma(Long turmaId) {
        return mensagemRepository.findByTurmaIdOrderByDataEnvioAsc(turmaId).stream()
                .map(MensagemMapper::toDTO)
                .collect(Collectors.toList());
    }
}
