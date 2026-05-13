package com.sistema.academico.controller;

import com.sistema.academico.dto.ApiResponseDTO;
import com.sistema.academico.dto.request.NotaRequestDTO;
import com.sistema.academico.dto.response.NotaResponseDTO;
import com.sistema.academico.service.NotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<NotaResponseDTO>> salvar(@RequestBody @Valid NotaRequestDTO dto) {
        return ResponseEntity.ok(ApiResponseDTO.success(notaService.salvar(dto)));
    }

    @GetMapping("/matricula/{matriculaId}")
    public ResponseEntity<ApiResponseDTO<List<NotaResponseDTO>>> listarPorMatricula(@PathVariable Long matriculaId) {
        return ResponseEntity.ok(ApiResponseDTO.success(notaService.listarPorMatricula(matriculaId)));
    }
}
