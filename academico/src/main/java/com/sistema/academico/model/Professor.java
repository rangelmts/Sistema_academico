package com.sistema.academico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pro_professor", schema = "academico")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_nr_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "usu_nr_id", nullable = false)
    private Usuario usuario;

    @Column(name = "pro_tx_matricula_siape", length = 50)
    private String matriculaSiape;

    @Column(name = "pro_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = "A";
}