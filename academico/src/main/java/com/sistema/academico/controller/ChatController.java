package com.sistema.academico.controller;

import com.sistema.academico.dto.ApiResponseDTO;
import com.sistema.academico.dto.request.MensagemRequestDTO;
import com.sistema.academico.dto.response.MensagemResponseDTO;
import com.sistema.academico.service.ChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensagens")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<MensagemResponseDTO>> enviar(@RequestBody @Valid MensagemRequestDTO dto) {
        return ResponseEntity.ok(ApiResponseDTO.success(chatService.enviarMensagem(dto)));
    }

    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<ApiResponseDTO<List<MensagemResponseDTO>>> listarPorTurma(@PathVariable Long turmaId) {
        return ResponseEntity.ok(ApiResponseDTO.success(chatService.listarPorTurma(turmaId)));
    }
}
