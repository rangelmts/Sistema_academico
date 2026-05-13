package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.FrequenciaRequestDTO;
import com.sistema.academico.dto.response.FrequenciaResponseDTO;
import com.sistema.academico.entity.Frequencia;
import com.sistema.academico.entity.MatriculaTurma;

public class FrequenciaMapper {

    public static Frequencia toEntity(FrequenciaRequestDTO dto) {
        if (dto == null) return null;
        return Frequencia.builder()
                .matriculaTurma(MatriculaTurma.builder().id(dto.getMatriculaTurmaId()).build())
                .dataAula(dto.getDataAula())
                .presente(dto.getPresente())
                .observacao(dto.getObservacao())
                .build();
    }

    public static FrequenciaResponseDTO toDTO(Frequencia entity) {
        if (entity == null) return null;
        return FrequenciaResponseDTO.builder()
                .id(entity.getId())
                .matriculaTurmaId(entity.getMatriculaTurma() != null ? entity.getMatriculaTurma().getId() : null)
                .dataAula(entity.getDataAula())
                .presente(entity.getPresente())
                .observacao(entity.getObservacao())
                .status(entity.getStatus())
                .build();
    }
}
