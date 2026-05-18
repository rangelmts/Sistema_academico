package com.sistema.academico.entity;

import com.sistema.academico.enums.PerfilUsuario;
import com.sistema.academico.enums.StatusRegistro;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entidade que representa um usuário no sistema acadêmico.
 * Gerencia as credenciais e o perfil de acesso (ALUNO, PROFESSOR, COORDENADOR).
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usu_usuario", schema = "academico")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_nr_id")
    private Long id;

    @Column(name = "usu_tx_nome", nullable = false)
    private String nome;

    @Column(name = "usu_tx_email", nullable = false, unique = true)
    private String email;

    @Column(name = "usu_tx_login", nullable = false, unique = true)
    private String login;

    @Column(name = "usu_tx_senha")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "usu_tx_perfil", nullable = false)
    private PerfilUsuario perfil;

    @Builder.Default
    @Column(name = "usu_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = StatusRegistro.ATIVO.getCodigo();

    @Builder.Default
    @Column(name = "usu_dt_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();
}
