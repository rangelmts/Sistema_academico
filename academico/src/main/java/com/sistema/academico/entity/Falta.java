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
@Table(name = "fal_falta", schema = "academico")
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fal_nr_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mat_nr_id", nullable = false)
    private MatriculaTurma matriculaTurma;

    @Column(name = "fal_dt_aula", nullable = false)
    private LocalDate dataAula;

    @Builder.Default
    @Column(name = "fal_nr_quantidade", nullable = false)
    private Integer quantidade = 1;

    @Column(name = "fal_tx_justificativa", columnDefinition = "TEXT")
    private String justificativa;

    @Column(name = "fal_tx_codigo_suap", length = 100)
    private String codigoSuap;

}
