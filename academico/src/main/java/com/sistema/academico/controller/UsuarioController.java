package com.sistema.academico.controller;

import com.sistema.academico.model.Usuario;
import com.sistema.academico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe responde a requisições WEB
@RequestMapping("/usuarios") // O endereço base será http://localhost:8080/usuarios
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping // Quando alguém acessar a URL, este método será chamado
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }
}