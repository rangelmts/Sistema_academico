package com.sistema.academico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tur_turma", schema = "academico")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tur_nr_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dis_nr_id", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "pro_nr_id", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "pel_nr_id", nullable = false)
    private PeriodoLetivo periodoLetivo;

    @Column(name = "tur_tx_descricao", nullable = false, length = 150)
    private String descricao;

    @Column(name = "tur_tx_codigo_suap", length = 100)
    private String codigoSuap;

    @Column(name = "tur_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = "A";
}