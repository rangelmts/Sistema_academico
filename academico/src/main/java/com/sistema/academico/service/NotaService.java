package com.sistema.academico.service;

import com.sistema.academico.dto.request.NotaRequestDTO;
import com.sistema.academico.dto.response.NotaResponseDTO;
import java.util.List;

public interface NotaService {
    NotaResponseDTO salvar(NotaRequestDTO dto);
    List<NotaResponseDTO> listarPorMatricula(Long matriculaId);
}
