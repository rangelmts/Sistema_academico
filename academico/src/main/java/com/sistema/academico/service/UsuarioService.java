package com.sistema.academico.service;

import com.sistema.academico.model.Usuario;
import com.sistema.academico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Avisa ao Spring que esta é a camada de lógica
public class UsuarioService {

    @Autowired // O Spring "injeta" o Repository aqui automaticamente
    private UsuarioRepository usuarioRepository;

    // Método para listar todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Método para salvar um novo usuário
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Aqui criaremos a lógica para "simular" a vinda de dados do SUAP futuramente
}