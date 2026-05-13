INSERT INTO academico.cur_curso (cur_tx_nome, cur_tx_codigo_suap) VALUES
('Sistemas de Informação', 'SI001'),
('Engenharia de Software', 'ES002');

UPDATE academico.alu_aluno SET cur_nr_id = 1 WHERE alu_tx_matricula = '2024001';
UPDATE academico.alu_aluno SET cur_nr_id = 2 WHERE alu_tx_matricula = '2024002';

INSERT INTO academico.dis_disciplina (dis_tx_nome, dis_tx_codigo, dis_nr_carga_horaria) VALUES
('Programação Orientada a Objetos', 'POO-01', 80),
('Banco de Dados', 'BD-02', 60),
('Desenvolvimento Web', 'WEB-03', 80);

INSERT INTO academico.pel_periodo_letivo (pel_nr_ano, pel_nr_semestre, pel_tx_descricao) VALUES
(2024, 1, 'Primeiro Semestre de 2024'),
(2024, 2, 'Segundo Semestre de 2024');
