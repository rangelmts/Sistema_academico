package com.sistema.academico.repository;

import com.sistema.academico.entity.ChatTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatTurmaRepository extends JpaRepository<ChatTurma, Long> {
}
