package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.UsuarioRequestDTO;
import com.sistema.academico.dto.response.UsuarioResponseDTO;
import com.sistema.academico.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) return null;
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .login(dto.getLogin())
                .senha(dto.getSenha())
                .perfil(dto.getPerfil())
                .build();
    }

    public static UsuarioResponseDTO toDTO(Usuario entity) {
        if (entity == null) return null;
        return UsuarioResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .login(entity.getLogin())
                .perfil(entity.getPerfil().name())
                .status(entity.getStatus())
                .dataCadastro(entity.getDataCadastro())
                .build();
    }
}
