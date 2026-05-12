package com.sistema.academico.repository;

import com.sistema.academico.model.PeriodoLetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoLetivoRepository extends JpaRepository<PeriodoLetivo, Long> { }