package com.sistema.academico.service;

import com.sistema.academico.dto.request.AlunoRequestDTO;
import com.sistema.academico.dto.response.AlunoResponseDTO;
import java.util.List;

public interface AlunoService {
    List<AlunoResponseDTO> listarTodos();
    AlunoResponseDTO salvar(AlunoRequestDTO dto);
    AlunoResponseDTO buscarPorId(Long id);
    void inativar(Long id);
}
