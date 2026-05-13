INSERT INTO academico.ava_avaliacao (mtu_nr_id, ava_nr_nota, ava_tx_descricao) VALUES
(1, 8.5, 'Primeira Prova'),
(2, 7.0, 'Primeira Prova'),
(3, 9.0, 'Trabalho Prático');

INSERT INTO academico.fre_frequencia (mtu_nr_id, fre_dt_aula, fre_bl_presente) VALUES
(1, '2024-03-01', TRUE),
(2, '2024-03-01', TRUE),
(1, '2024-03-05', FALSE);

INSERT INTO academico.msg_mensagem (tur_nr_id, usu_nr_id, msg_tx_conteudo) VALUES
(1, 2, 'Bem-vindos à disciplina de POO!'),
(1, 4, 'Olá professor, obrigado!'),
(2, 3, 'Bom dia pessoal, hoje falaremos sobre SQL.');
