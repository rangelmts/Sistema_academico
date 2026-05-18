package com.sistema.academico.service.impl;

import com.sistema.academico.dto.request.AlunoRequestDTO;
import com.sistema.academico.dto.response.AlunoResponseDTO;
import com.sistema.academico.entity.Aluno;
import com.sistema.academico.enums.StatusRegistro;
import com.sistema.academico.mapper.AlunoMapper;
import com.sistema.academico.repository.AlunoRepository;
import com.sistema.academico.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll().stream()
                .map(AlunoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AlunoResponseDTO salvar(AlunoRequestDTO dto) {
        Aluno entity = AlunoMapper.toEntity(dto);
        return AlunoMapper.toDTO(alunoRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public AlunoResponseDTO buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .map(AlunoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @Override
    @Transactional
    public void inativar(Long id) {
        Aluno entity = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        entity.setStatus(StatusRegistro.INATIVO.getCodigo());
        alunoRepository.save(entity);
    }
}
