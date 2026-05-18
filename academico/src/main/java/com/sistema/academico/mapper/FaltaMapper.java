package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.FaltaRequestDTO;
import com.sistema.academico.dto.response.FaltaResponseDTO;
import com.sistema.academico.entity.Falta;
import com.sistema.academico.entity.MatriculaTurma;

public class FaltaMapper {

    public static Falta toEntity(FaltaRequestDTO dto) {
        if (dto == null) return null;
        return Falta.builder()
                .matriculaTurma(MatriculaTurma.builder().id(dto.getMatriculaTurmaId()).build())
                .dataAula(dto.getDataAula())
                .quantidade(dto.getQuantidade() != null ? dto.getQuantidade() : 1)
                .justificativa(dto.getJustificativa())
                .codigoSuap(dto.getCodigoSuap())
                .build();
    }

    public static FaltaResponseDTO toDTO(Falta entity) {
        if (entity == null) return null;
        return FaltaResponseDTO.builder()
                .id(entity.getId())
                .matriculaTurmaId(entity.getMatriculaTurma() != null ? entity.getMatriculaTurma().getId() : null)
                .dataAula(entity.getDataAula())
                .quantidade(entity.getQuantidade())
                .justificativa(entity.getJustificativa())
                .codigoSuap(entity.getCodigoSuap())
                .build();
    }
}
