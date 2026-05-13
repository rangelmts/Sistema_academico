INSERT INTO academico.usu_usuario (usu_tx_nome, usu_tx_email, usu_tx_login, usu_tx_senha, usu_tx_perfil) VALUES
('Coordenador Geral', 'admin@academico.com.br', 'admin', 'admin123', 'COORDENADOR'),
('Professor João Silva', 'joao.silva@academico.com.br', 'joao.silva', 'prof123', 'PROFESSOR'),
('Professora Maria Oliveira', 'maria.oliveira@academico.com.br', 'maria.oliveira', 'prof123', 'PROFESSOR'),
('Aluno Pedro Santos', 'pedro.santos@estudante.com.br', 'pedro.santos', 'aluno123', 'ALUNO'),
('Aluna Ana Costa', 'ana.costa@estudante.com.br', 'ana.costa', 'aluno123', 'ALUNO');

INSERT INTO academico.pro_professor (usu_nr_id, pro_tx_matricula_siape) VALUES
(2, '1234567'),
(3, '7654321');

INSERT INTO academico.alu_aluno (usu_nr_id, alu_tx_matricula) VALUES
(4, '2024001'),
(5, '2024002');
