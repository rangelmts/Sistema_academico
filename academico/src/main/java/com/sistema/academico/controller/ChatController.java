package com.sistema.academico.controller;

import com.sistema.academico.dto.ApiResponseDTO;
import com.sistema.academico.dto.request.ChatMensagemRequestDTO;
import com.sistema.academico.dto.response.ChatMensagemResponseDTO;
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
    public ResponseEntity<ApiResponseDTO<ChatMensagemResponseDTO>> enviar(@RequestBody @Valid ChatMensagemRequestDTO dto) {
        return ResponseEntity.ok(ApiResponseDTO.success(chatService.enviarMensagem(dto)));
    }

    @GetMapping("/chat/{chatId}")
    public ResponseEntity<ApiResponseDTO<List<ChatMensagemResponseDTO>>> listarPorChat(@PathVariable Long chatId) {
        return ResponseEntity.ok(ApiResponseDTO.success(chatService.listarPorChat(chatId)));
    }
}
