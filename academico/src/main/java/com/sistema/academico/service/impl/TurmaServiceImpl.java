package com.sistema.academico.service.impl;

import com.sistema.academico.dto.request.TurmaRequestDTO;
import com.sistema.academico.dto.response.TurmaResponseDTO;
import com.sistema.academico.entity.Turma;
import com.sistema.academico.enums.StatusRegistro;
import com.sistema.academico.mapper.TurmaMapper;
import com.sistema.academico.repository.TurmaRepository;
import com.sistema.academico.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository turmaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TurmaResponseDTO> listarTodos() {
        return turmaRepository.findAll().stream()
                .map(TurmaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TurmaResponseDTO salvar(TurmaRequestDTO dto) {
        Turma entity = TurmaMapper.toEntity(dto);
        return TurmaMapper.toDTO(turmaRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public TurmaResponseDTO buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .map(TurmaMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    @Override
    @Transactional
    public void inativar(Long id) {
        Turma entity = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        entity.setStatus(StatusRegistro.INATIVO.getCodigo());
        turmaRepository.save(entity);
    }
}
