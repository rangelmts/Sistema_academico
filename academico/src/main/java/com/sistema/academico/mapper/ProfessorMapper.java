package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.ProfessorRequestDTO;
import com.sistema.academico.dto.response.ProfessorResponseDTO;
import com.sistema.academico.entity.Professor;
import com.sistema.academico.entity.Usuario;

public class ProfessorMapper {

    public static Professor toEntity(ProfessorRequestDTO dto) {
        if (dto == null) return null;
        return Professor.builder()
                .usuario(Usuario.builder().id(dto.getUsuarioId()).build())
                .matriculaSiape(dto.getMatriculaSiape())
                .build();
    }

    public static ProfessorResponseDTO toDTO(Professor entity) {
        if (entity == null) return null;
        return ProfessorResponseDTO.builder()
                .id(entity.getId())
                .usuario(UsuarioMapper.toDTO(entity.getUsuario()))
                .matriculaSiape(entity.getMatriculaSiape())
                .status(entity.getStatus())
                .build();
    }
}
