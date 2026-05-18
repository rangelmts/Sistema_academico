package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.NotaRequestDTO;
import com.sistema.academico.dto.response.NotaResponseDTO;
import com.sistema.academico.entity.MatriculaTurma;
import com.sistema.academico.entity.Nota;

public class NotaMapper {

    public static Nota toEntity(NotaRequestDTO dto) {
        if (dto == null) return null;
        return Nota.builder()
                .matriculaTurma(MatriculaTurma.builder().id(dto.getMatriculaTurmaId()).build())
                .descricao(dto.getDescricao())
                .valor(dto.getValor())
                .peso(dto.getPeso())
                .dataAvaliacao(dto.getDataAvaliacao())
                .codigoSuap(dto.getCodigoSuap())
                .build();
    }

    public static NotaResponseDTO toDTO(Nota entity) {
        if (entity == null) return null;
        return NotaResponseDTO.builder()
                .id(entity.getId())
                .matriculaTurmaId(entity.getMatriculaTurma() != null ? entity.getMatriculaTurma().getId() : null)
                .descricao(entity.getDescricao())
                .valor(entity.getValor())
                .peso(entity.getPeso())
                .dataAvaliacao(entity.getDataAvaliacao())
                .codigoSuap(entity.getCodigoSuap())
                .build();
    }
}
