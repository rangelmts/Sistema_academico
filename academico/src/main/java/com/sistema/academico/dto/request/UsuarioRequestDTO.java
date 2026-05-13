package com.sistema.academico.dto.request;

import com.sistema.academico.enums.PerfilUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "O login é obrigatório")
    private String login;

    private String senha;

    @NotNull(message = "O perfil é obrigatório")
    private PerfilUsuario perfil;
}
