package com.sistema.academico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dis_disciplina", schema = "academico")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dis_nr_id")
    private Long id;

    @Column(name = "dis_tx_nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "dis_tx_codigo", length = 50)
    private String codigo;

    @Column(name = "dis_nr_carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "dis_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = "A";
}