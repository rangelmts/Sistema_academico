package com.sistema.academico.service;

import com.sistema.academico.dto.request.ProfessorRequestDTO;
import com.sistema.academico.dto.response.ProfessorResponseDTO;
import java.util.List;

public interface ProfessorService {
    List<ProfessorResponseDTO> listarTodos();
    ProfessorResponseDTO salvar(ProfessorRequestDTO dto);
    ProfessorResponseDTO buscarPorId(Long id);
    void inativar(Long id);
}
