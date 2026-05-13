package com.sistema.academico.controller;

import com.sistema.academico.dto.ApiResponseDTO;
import com.sistema.academico.dto.request.UsuarioRequestDTO;
import com.sistema.academico.dto.response.UsuarioResponseDTO;
import com.sistema.academico.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<UsuarioResponseDTO>>> listar() {
        return ResponseEntity.ok(ApiResponseDTO.success(usuarioService.listarTodos()));
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<UsuarioResponseDTO>> salvar(@RequestBody @Valid UsuarioRequestDTO dto) {
        return ResponseEntity.ok(ApiResponseDTO.success(usuarioService.salvar(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<UsuarioResponseDTO>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponseDTO.success(usuarioService.buscarPorId(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> inativar(@PathVariable Long id) {
        usuarioService.inativar(id);
        return ResponseEntity.ok(ApiResponseDTO.success(null));
    }
}