package com.sistema.academico.service.impl;

import com.sistema.academico.dto.request.NotaRequestDTO;
import com.sistema.academico.dto.response.NotaResponseDTO;
import com.sistema.academico.entity.Nota;
import com.sistema.academico.mapper.NotaMapper;
import com.sistema.academico.repository.NotaRepository;
import com.sistema.academico.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;

    @Override
    @Transactional
    public NotaResponseDTO salvar(NotaRequestDTO dto) {
        Nota entity = NotaMapper.toEntity(dto);
        return NotaMapper.toDTO(notaRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotaResponseDTO> listarPorMatricula(Long matriculaId) {
        // Para simplificar, retornando todos. Em um cenário real, filtraria por matriculaId
        return notaRepository.findAll().stream()
                .map(NotaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
