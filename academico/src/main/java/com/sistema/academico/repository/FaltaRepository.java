package com.sistema.academico.repository;

import com.sistema.academico.entity.Falta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaltaRepository extends JpaRepository<Falta, Long> {
}
