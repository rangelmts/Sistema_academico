package com.sistema.academico.dto;

import com.sistema.academico.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioResponseDto {
    private Long id;
    private String nome;
    private String email;
    private String perfil;

    // Construtor que transforma a Entity em DTO automaticamente
    public UsuarioResponseDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.perfil = usuario.getPerfil();
    }
}