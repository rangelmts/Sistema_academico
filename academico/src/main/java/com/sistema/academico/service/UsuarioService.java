package com.sistema.academico.service;

import com.sistema.academico.dto.UsuarioResponseDto;
import com.sistema.academico.entity.Usuario;
import com.sistema.academico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para listar todos os usuários (devolvendo DTO)
    public List<UsuarioResponseDto> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(UsuarioResponseDto::new)
                .collect(Collectors.toList());
    }

    // Método para salvar um novo usuário
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}