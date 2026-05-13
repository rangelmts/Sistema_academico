package com.sistema.academico.controller;

import com.sistema.academico.dto.ApiResponseDTO;
import com.sistema.academico.dto.request.TurmaRequestDTO;
import com.sistema.academico.dto.response.TurmaResponseDTO;
import com.sistema.academico.service.TurmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<TurmaResponseDTO>>> listar() {
        return ResponseEntity.ok(ApiResponseDTO.success(turmaService.listarTodos()));
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<TurmaResponseDTO>> salvar(@RequestBody @Valid TurmaRequestDTO dto) {
        return ResponseEntity.ok(ApiResponseDTO.success(turmaService.salvar(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<TurmaResponseDTO>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponseDTO.success(turmaService.buscarPorId(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> inativar(@PathVariable Long id) {
        turmaService.inativar(id);
        return ResponseEntity.ok(ApiResponseDTO.success(null));
    }
}
