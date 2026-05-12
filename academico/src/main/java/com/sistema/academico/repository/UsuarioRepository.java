package com.sistema.academico.repository;

import com.sistema.academico.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aqui o Spring já nos dá métodos como save(), findAll(), findById()
}