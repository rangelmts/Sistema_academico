package com.sistema.academico.service;

import com.sistema.academico.dto.request.UsuarioRequestDTO;
import com.sistema.academico.dto.response.UsuarioResponseDTO;
import java.util.List;

public interface UsuarioService {
    List<UsuarioResponseDTO> listarTodos();
    UsuarioResponseDTO salvar(UsuarioRequestDTO dto);
    UsuarioResponseDTO buscarPorId(Long id);
    void inativar(Long id);
}