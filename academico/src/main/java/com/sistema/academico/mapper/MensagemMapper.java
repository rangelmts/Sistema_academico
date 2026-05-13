package com.sistema.academico.mapper;

import com.sistema.academico.dto.request.MensagemRequestDTO;
import com.sistema.academico.dto.response.MensagemResponseDTO;
import com.sistema.academico.entity.Mensagem;
import com.sistema.academico.entity.Turma;
import com.sistema.academico.entity.Usuario;

public class MensagemMapper {

    public static Mensagem toEntity(MensagemRequestDTO dto) {
        if (dto == null) return null;
        return Mensagem.builder()
                .turma(Turma.builder().id(dto.getTurmaId()).build())
                .autor(Usuario.builder().id(dto.getAutorId()).build())
                .conteudo(dto.getConteudo())
                .build();
    }

    public static MensagemResponseDTO toDTO(Mensagem entity) {
        if (entity == null) return null;
        return MensagemResponseDTO.builder()
                .id(entity.getId())
                .autorNome(entity.getAutor() != null ? entity.getAutor().getNome() : null)
                .conteudo(entity.getConteudo())
                .dataEnvio(entity.getDataEnvio())
                .build();
    }
}
