package com.sistema.academico.repository;

import com.sistema.academico.entity.ChatMensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatMensagemRepository extends JpaRepository<ChatMensagem, Long> {
    List<ChatMensagem> findByChatIdOrderByDataEnvioAsc(Long chatId);
}
