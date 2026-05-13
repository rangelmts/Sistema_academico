package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.DisciplinaRequestDTO;
import com.sistema.academico.dto.response.DisciplinaResponseDTO;
import com.sistema.academico.entity.Disciplina;

public class DisciplinaMapper {

    public static Disciplina toEntity(DisciplinaRequestDTO dto) {
        if (dto == null) return null;
        return Disciplina.builder()
                .nome(dto.getNome())
                .codigo(dto.getCodigo())
                .cargaHoraria(dto.getCargaHoraria())
                .build();
    }

    public static DisciplinaResponseDTO toDTO(Disciplina entity) {
        if (entity == null) return null;
        return DisciplinaResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .codigo(entity.getCodigo())
                .cargaHoraria(entity.getCargaHoraria())
                .status(entity.getStatus())
                .build();
    }
}
