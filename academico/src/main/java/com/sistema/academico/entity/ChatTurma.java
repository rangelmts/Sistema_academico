package com.sistema.academico.entity;

import com.sistema.academico.enums.StatusRegistro;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cht_chat_turma", schema = "academico")
public class ChatTurma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cht_nr_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tur_nr_id", nullable = false)
    private Turma turma;

    @Column(name = "cht_tx_titulo", length = 150)
    private String titulo;

    @Builder.Default
    @Column(name = "cht_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = StatusRegistro.ATIVO.getCodigo();

    @Builder.Default
    @Column(name = "cht_dt_criacao", nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();
}
