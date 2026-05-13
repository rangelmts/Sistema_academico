package com.sistema.academico.entity;

import com.sistema.academico.enums.StatusRegistro;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ava_avaliacao", schema = "academico")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ava_nr_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mtu_nr_id", nullable = false)
    private MatriculaTurma matriculaTurma;

    @Column(name = "ava_nr_nota", precision = 5, scale = 2)
    private BigDecimal nota;

    @Column(name = "ava_tx_descricao", length = 100)
    private String descricao;

    @Column(name = "ava_dt_lancamento", nullable = false)
    private LocalDateTime dataLancamento = LocalDateTime.now();

    @Column(name = "ava_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = StatusRegistro.ATIVO.getCodigo();
}
