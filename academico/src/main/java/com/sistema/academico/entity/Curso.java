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
@Table(name = "cur_curso", schema = "academico")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cur_nr_id")
    private Long id;

    @Column(name = "cur_tx_nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "cur_tx_codigo_suap", length = 100)
    private String codigoSuap;

    @Column(name = "cur_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = StatusRegistro.ATIVO.getCodigo();
}
