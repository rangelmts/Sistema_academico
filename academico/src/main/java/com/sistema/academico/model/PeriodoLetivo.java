package com.sistema.academico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pel_periodo_letivo", schema = "academico")
public class PeriodoLetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pel_nr_id")
    private Long id;

    @Column(name = "pel_nr_ano", nullable = false)
    private Integer ano;

    @Column(name = "pel_nr_semestre", nullable = false)
    private Integer semestre;

    @Column(name = "pel_tx_descricao", nullable = false, length = 50)
    private String descricao;

    @Column(name = "pel_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = "A";
}