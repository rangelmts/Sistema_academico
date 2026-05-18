package com.sistema.academico.entity;

import com.sistema.academico.enums.StatusRegistro;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mat_matricula_turma", schema = "academico")
public class MatriculaTurma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_nr_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alu_nr_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tur_nr_id", nullable = false)
    private Turma turma;

    @Builder.Default
    @Column(name = "mat_dt_matricula", nullable = false)
    private LocalDate dataMatricula = LocalDate.now();

    @Builder.Default
    @Column(name = "mat_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = StatusRegistro.ATIVO.getCodigo();
}
