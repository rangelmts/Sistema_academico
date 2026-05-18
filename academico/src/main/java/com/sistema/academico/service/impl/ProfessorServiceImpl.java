package com.sistema.academico.service.impl;

import com.sistema.academico.dto.request.ProfessorRequestDTO;
import com.sistema.academico.dto.response.ProfessorResponseDTO;
import com.sistema.academico.entity.Professor;
import com.sistema.academico.enums.StatusRegistro;
import com.sistema.academico.mapper.ProfessorMapper;
import com.sistema.academico.repository.ProfessorRepository;
import com.sistema.academico.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProfessorResponseDTO> listarTodos() {
        return professorRepository.findAll().stream()
                .map(ProfessorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProfessorResponseDTO salvar(ProfessorRequestDTO dto) {
        Professor entity = ProfessorMapper.toEntity(dto);
        return ProfessorMapper.toDTO(professorRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public ProfessorResponseDTO buscarPorId(Long id) {
        return professorRepository.findById(id)
                .map(ProfessorMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    @Override
    @Transactional
    public void inativar(Long id) {
        Professor entity = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        entity.setStatus(StatusRegistro.INATIVO.getCodigo());
        professorRepository.save(entity);
    }
}
