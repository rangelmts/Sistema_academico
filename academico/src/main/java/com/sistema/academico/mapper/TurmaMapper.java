package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.TurmaRequestDTO;
import com.sistema.academico.dto.response.TurmaResponseDTO;
import com.sistema.academico.entity.*;

public class TurmaMapper {

    public static Turma toEntity(TurmaRequestDTO dto) {
        if (dto == null) return null;
        return Turma.builder()
                .disciplina(Disciplina.builder().id(dto.getDisciplinaId()).build())
                .professor(Professor.builder().id(dto.getProfessorId()).build())
                .periodoLetivo(PeriodoLetivo.builder().id(dto.getPeriodoLetivoId()).build())
                .descricao(dto.getDescricao())
                .codigoSuap(dto.getCodigoSuap())
                .build();
    }

    public static TurmaResponseDTO toDTO(Turma entity) {
        if (entity == null) return null;
        return TurmaResponseDTO.builder()
                .id(entity.getId())
                .disciplina(DisciplinaMapper.toDTO(entity.getDisciplina()))
                .professor(ProfessorMapper.toDTO(entity.getProfessor()))
                .periodoLetivoDescricao(entity.getPeriodoLetivo() != null ? entity.getPeriodoLetivo().getDescricao() : null)
                .descricao(entity.getDescricao())
                .codigoSuap(entity.getCodigoSuap())
                .status(entity.getStatus())
                .build();
    }
}
