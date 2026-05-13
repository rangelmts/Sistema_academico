package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.AvaliacaoRequestDTO;
import com.sistema.academico.dto.response.AvaliacaoResponseDTO;
import com.sistema.academico.entity.Avaliacao;
import com.sistema.academico.entity.MatriculaTurma;

public class AvaliacaoMapper {

    public static Avaliacao toEntity(AvaliacaoRequestDTO dto) {
        if (dto == null) return null;
        return Avaliacao.builder()
                .matriculaTurma(MatriculaTurma.builder().id(dto.getMatriculaTurmaId()).build())
                .nota(dto.getNota())
                .descricao(dto.getDescricao())
                .build();
    }

    public static AvaliacaoResponseDTO toDTO(Avaliacao entity) {
        if (entity == null) return null;
        return AvaliacaoResponseDTO.builder()
                .id(entity.getId())
                .matriculaTurmaId(entity.getMatriculaTurma() != null ? entity.getMatriculaTurma().getId() : null)
                .nota(entity.getNota())
                .descricao(entity.getDescricao())
                .dataLancamento(entity.getDataLancamento())
                .status(entity.getStatus())
                .build();
    }
}
