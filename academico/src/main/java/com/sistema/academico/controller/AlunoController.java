package com.sistema.academico.controller;

import com.sistema.academico.dto.ApiResponseDTO;
import com.sistema.academico.dto.request.AlunoRequestDTO;
import com.sistema.academico.dto.response.AlunoResponseDTO;
import com.sistema.academico.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<AlunoResponseDTO>>> listar() {
        return ResponseEntity.ok(ApiResponseDTO.success(alunoService.listarTodos()));
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<AlunoResponseDTO>> salvar(@RequestBody @Valid AlunoRequestDTO dto) {
        return ResponseEntity.ok(ApiResponseDTO.success(alunoService.salvar(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<AlunoResponseDTO>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponseDTO.success(alunoService.buscarPorId(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> inativar(@PathVariable Long id) {
        alunoService.inativar(id);
        return ResponseEntity.ok(ApiResponseDTO.success(null));
    }
}
