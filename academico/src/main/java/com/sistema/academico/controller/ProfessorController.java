package com.sistema.academico.controller;

import com.sistema.academico.dto.ApiResponseDTO;
import com.sistema.academico.dto.request.ProfessorRequestDTO;
import com.sistema.academico.dto.response.ProfessorResponseDTO;
import com.sistema.academico.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<ProfessorResponseDTO>>> listar() {
        return ResponseEntity.ok(ApiResponseDTO.success(professorService.listarTodos()));
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<ProfessorResponseDTO>> salvar(@RequestBody @Valid ProfessorRequestDTO dto) {
        return ResponseEntity.ok(ApiResponseDTO.success(professorService.salvar(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<ProfessorResponseDTO>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponseDTO.success(professorService.buscarPorId(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> inativar(@PathVariable Long id) {
        professorService.inativar(id);
        return ResponseEntity.ok(ApiResponseDTO.success(null));
    }
}
