package com.sistema.academico.service;

import com.sistema.academico.dto.request.TurmaRequestDTO;
import com.sistema.academico.dto.response.TurmaResponseDTO;
import java.util.List;

public interface TurmaService {
    List<TurmaResponseDTO> listarTodos();
    TurmaResponseDTO salvar(TurmaRequestDTO dto);
    TurmaResponseDTO buscarPorId(Long id);
    void inativar(Long id);
}
