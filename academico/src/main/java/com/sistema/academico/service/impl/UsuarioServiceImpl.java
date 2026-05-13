package com.sistema.academico.service.impl;

import com.sistema.academico.dto.request.UsuarioRequestDTO;
import com.sistema.academico.dto.response.UsuarioResponseDTO;
import com.sistema.academico.entity.Usuario;
import com.sistema.academico.enums.StatusRegistro;
import com.sistema.academico.mapper.UsuarioMapper;
import com.sistema.academico.repository.UsuarioRepository;
import com.sistema.academico.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {
        Usuario entity = UsuarioMapper.toEntity(dto);
        return UsuarioMapper.toDTO(usuarioRepository.save(entity));
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    @Transactional
    public void inativar(Long id) {
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        entity.setStatus(StatusRegistro.INATIVO.getCodigo());
        usuarioRepository.save(entity);
    }
}
