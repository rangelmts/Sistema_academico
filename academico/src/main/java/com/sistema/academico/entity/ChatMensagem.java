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
@Table(name = "msg_chat_mensagem", schema = "academico")
public class ChatMensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "msg_nr_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cht_nr_id", nullable = false)
    private ChatTurma chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_nr_id", nullable = false)
    private Usuario usuario;

    @Column(name = "msg_tx_mensagem", nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @Column(name = "msg_dt_envio", nullable = false)
    private LocalDateTime dataEnvio = LocalDateTime.now();

    @Column(name = "msg_tx_status", nullable = false, columnDefinition = "bpchar(1)")
    private String status = StatusRegistro.ATIVO.getCodigo();
}
