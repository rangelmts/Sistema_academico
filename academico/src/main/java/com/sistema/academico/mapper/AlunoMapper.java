package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.AlunoRequestDTO;
import com.sistema.academico.dto.response.AlunoResponseDTO;
import com.sistema.academico.entity.Aluno;
import com.sistema.academico.entity.Curso;
import com.sistema.academico.entity.Usuario;

public class AlunoMapper {

    public static Aluno toEntity(AlunoRequestDTO dto) {
        if (dto == null) return null;
        return Aluno.builder()
                .usuario(Usuario.builder().id(dto.getUsuarioId()).build())
                .curso(dto.getCursoId() != null ? Curso.builder().id(dto.getCursoId()).build() : null)
                .matricula(dto.getMatricula())
                .build();
    }

    public static AlunoResponseDTO toDTO(Aluno entity) {
        if (entity == null) return null;
        return AlunoResponseDTO.builder()
                .id(entity.getId())
                .usuario(UsuarioMapper.toDTO(entity.getUsuario()))
                .cursoNome(entity.getCurso() != null ? entity.getCurso().getNome() : null)
                .matricula(entity.getMatricula())
                .status(entity.getStatus())
                .build();
    }
}
