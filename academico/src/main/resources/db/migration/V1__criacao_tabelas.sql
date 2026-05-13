CREATE SCHEMA IF NOT EXISTS academico;

CREATE TABLE academico.usu_usuario (
    usu_nr_id SERIAL PRIMARY KEY,
    usu_tx_nome VARCHAR(255) NOT NULL,
    usu_tx_email VARCHAR(255) NOT NULL UNIQUE,
    usu_tx_login VARCHAR(255) NOT NULL UNIQUE,
    usu_tx_senha VARCHAR(255),
    usu_tx_perfil VARCHAR(50) NOT NULL,
    usu_tx_status CHAR(1) NOT NULL DEFAULT 'A',
    usu_dt_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE academico.cur_curso (
    cur_nr_id SERIAL PRIMARY KEY,
    cur_tx_nome VARCHAR(150) NOT NULL,
    cur_tx_codigo_suap VARCHAR(100),
    cur_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.alu_aluno (
    alu_nr_id SERIAL PRIMARY KEY,
    usu_nr_id INTEGER NOT NULL REFERENCES academico.usu_usuario(usu_nr_id),
    cur_nr_id INTEGER REFERENCES academico.cur_curso(cur_nr_id),
    alu_tx_matricula VARCHAR(50) NOT NULL,
    alu_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.pro_professor (
    pro_nr_id SERIAL PRIMARY KEY,
    usu_nr_id INTEGER NOT NULL REFERENCES academico.usu_usuario(usu_nr_id),
    pro_tx_matricula_siape VARCHAR(50),
    pro_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.dis_disciplina (
    dis_nr_id SERIAL PRIMARY KEY,
    dis_tx_nome VARCHAR(150) NOT NULL,
    dis_tx_codigo VARCHAR(50),
    dis_nr_carga_horaria INTEGER,
    dis_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.pel_periodo_letivo (
    pel_nr_id SERIAL PRIMARY KEY,
    pel_nr_ano INTEGER NOT NULL,
    pel_nr_semestre INTEGER NOT NULL,
    pel_tx_descricao VARCHAR(50) NOT NULL,
    pel_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.tur_turma (
    tur_nr_id SERIAL PRIMARY KEY,
    dis_nr_id INTEGER NOT NULL REFERENCES academico.dis_disciplina(dis_nr_id),
    pro_nr_id INTEGER NOT NULL REFERENCES academico.pro_professor(pro_nr_id),
    pel_nr_id INTEGER NOT NULL REFERENCES academico.pel_periodo_letivo(pel_nr_id),
    tur_tx_descricao VARCHAR(150) NOT NULL,
    tur_tx_codigo_suap VARCHAR(100),
    tur_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.mtu_matricula_turma (
    mtu_nr_id SERIAL PRIMARY KEY,
    alu_nr_id INTEGER NOT NULL REFERENCES academico.alu_aluno(alu_nr_id),
    tur_nr_id INTEGER NOT NULL REFERENCES academico.tur_turma(tur_nr_id),
    mtu_dt_matricula TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    mtu_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.ava_avaliacao (
    ava_nr_id SERIAL PRIMARY KEY,
    mtu_nr_id INTEGER NOT NULL REFERENCES academico.mtu_matricula_turma(mtu_nr_id),
    ava_nr_nota DECIMAL(5,2),
    ava_tx_descricao VARCHAR(100),
    ava_dt_lancamento TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ava_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.fre_frequencia (
    fre_nr_id SERIAL PRIMARY KEY,
    mtu_nr_id INTEGER NOT NULL REFERENCES academico.mtu_matricula_turma(mtu_nr_id),
    fre_dt_aula DATE NOT NULL,
    fre_bl_presente BOOLEAN NOT NULL,
    fre_tx_observacao VARCHAR(200),
    fre_tx_status CHAR(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.msg_mensagem (
    msg_nr_id SERIAL PRIMARY KEY,
    tur_nr_id INTEGER NOT NULL REFERENCES academico.tur_turma(tur_nr_id),
    usu_nr_id INTEGER NOT NULL REFERENCES academico.usu_usuario(usu_nr_id),
    msg_tx_conteudo TEXT NOT NULL,
    msg_dt_envio TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    msg_bl_ativo BOOLEAN NOT NULL DEFAULT TRUE
);
