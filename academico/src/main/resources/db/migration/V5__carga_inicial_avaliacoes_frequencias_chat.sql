INSERT INTO academico.not_nota (mat_nr_id, not_nr_valor, not_tx_descricao) VALUES
(1, 8.5, 'Primeira Prova'),
(2, 7.0, 'Primeira Prova'),
(3, 9.0, 'Trabalho Prático');

INSERT INTO academico.fal_falta (mat_nr_id, fal_dt_aula, fal_nr_quantidade) VALUES
(1, '2024-03-01', 1),
(2, '2024-03-01', 1),
(1, '2024-03-05', 1);

INSERT INTO academico.cht_chat_turma (tur_nr_id, cht_tx_titulo) VALUES
(1, 'Chat de POO'),
(2, 'Chat de BD');

INSERT INTO academico.msg_chat_mensagem (cht_nr_id, usu_nr_id, msg_tx_mensagem) VALUES
(1, 2, 'Bem-vindos à disciplina de POO!'),
(1, 4, 'Olá professor, obrigado!'),
(2, 3, 'Bom dia pessoal, hoje falaremos sobre SQL.');
