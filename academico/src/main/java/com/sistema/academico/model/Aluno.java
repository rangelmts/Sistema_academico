package com.sistema.academico.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alu_aluno", schema = "academico")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alu_nr_id")
    private Long id;

    // Relacionamento 1 para 1: Um aluno é exatamente UM usuário
    @OneToOne
    @JoinColumn(name = "usu_nr_id", nullable = false)
    private Usuario usuario;

    // Relacionamento Muitos para 1: Vários alunos podem estar em UM curso
    @ManyToOne
    @JoinColumn(name = "cur_nr_id")
    private Curso curso;

    @Column(name = "alu_tx_matricula", nullable = false, length = 50)
    private String matricula;

    @Column(name = "alu_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = "A";
}