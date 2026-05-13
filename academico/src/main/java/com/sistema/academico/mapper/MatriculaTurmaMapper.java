package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.MatriculaTurmaRequestDTO;
import com.sistema.academico.dto.response.MatriculaTurmaResponseDTO;
import com.sistema.academico.entity.Aluno;
import com.sistema.academico.entity.MatriculaTurma;
import com.sistema.academico.entity.Turma;

public class MatriculaTurmaMapper {

    public static MatriculaTurma toEntity(MatriculaTurmaRequestDTO dto) {
        if (dto == null) return null;
        return MatriculaTurma.builder()
                .aluno(Aluno.builder().id(dto.getAlunoId()).build())
                .turma(Turma.builder().id(dto.getTurmaId()).build())
                .build();
    }

    public static MatriculaTurmaResponseDTO toDTO(MatriculaTurma entity) {
        if (entity == null) return null;
        return MatriculaTurmaResponseDTO.builder()
                .id(entity.getId())
                .aluno(AlunoMapper.toDTO(entity.getAluno()))
                .turma(TurmaMapper.toDTO(entity.getTurma()))
                .dataMatricula(entity.getDataMatricula())
                .status(entity.getStatus())
                .build();
    }
}
