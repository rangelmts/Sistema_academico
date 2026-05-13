INSERT INTO academico.tur_turma (dis_nr_id, pro_nr_id, pel_nr_id, tur_tx_descricao, tur_tx_codigo_suap) VALUES
(1, 1, 1, 'Turma POO - Noite', 'T-POO-2024-1'),
(2, 2, 1, 'Turma BD - Manhã', 'T-BD-2024-1');

INSERT INTO academico.mtu_matricula_turma (alu_nr_id, tur_nr_id) VALUES
(1, 1),
(2, 1),
(1, 2);
