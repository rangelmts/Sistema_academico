package com.sistema.academico.entity;

import com.sistema.academico.enums.StatusRegistro;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fre_frequencia", schema = "academico")
public class Frequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fre_nr_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mtu_nr_id", nullable = false)
    private MatriculaTurma matriculaTurma;

    @Column(name = "fre_dt_aula", nullable = false)
    private LocalDate dataAula;

    @Column(name = "fre_bl_presente", nullable = false)
    private Boolean presente;

    @Column(name = "fre_tx_observacao", length = 200)
    private String observacao;

    @Column(name = "fre_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = StatusRegistro.ATIVO.getCodigo();
}
