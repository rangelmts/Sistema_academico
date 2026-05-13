package com.sistema.academico.repository;

import com.sistema.academico.entity.MatriculaTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaTurmaRepository extends JpaRepository<MatriculaTurma, Long> {
}
