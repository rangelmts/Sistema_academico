package com.sistema.academico.entity;

import com.sistema.academico.enums.StatusRegistro;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "alu_aluno", schema = "academico")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alu_nr_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_nr_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cur_nr_id")
    private Curso curso;

    @Column(name = "alu_tx_matricula", nullable = false, length = 50)
    private String matricula;

    @Builder.Default
    @Column(name = "alu_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = StatusRegistro.ATIVO.getCodigo();
}
