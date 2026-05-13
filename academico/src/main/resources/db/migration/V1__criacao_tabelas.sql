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

CREATE TABLE academico.mat_matricula_turma (
    mat_nr_id SERIAL PRIMARY KEY,
    alu_nr_id INTEGER NOT NULL REFERENCES academico.alu_aluno(alu_nr_id),
    tur_nr_id INTEGER NOT NULL REFERENCES academico.tur_turma(tur_nr_id),
    mat_dt_matricula TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    mat_tx_status bpchar(1) NOT NULL DEFAULT 'A'
);

CREATE TABLE academico.not_nota (
    not_nr_id bigserial NOT NULL,
    mat_nr_id bigint NOT NULL,
    not_tx_descricao varchar(100) NOT NULL,
    not_nr_valor numeric(5,2),
    not_nr_peso numeric(5,2),
    not_dt_avaliacao date,
    not_tx_codigo_suap varchar(100),
    not_tx_status bpchar(1) NOT NULL DEFAULT 'A',
    CONSTRAINT not_nota_pk PRIMARY KEY (not_nr_id),
    CONSTRAINT not_matricula_fk FOREIGN KEY (mat_nr_id) REFERENCES academico.mat_matricula_turma(mat_nr_id)
);

CREATE TABLE academico.fal_falta (
    fal_nr_id bigserial NOT NULL,
    mat_nr_id bigint NOT NULL,
    fal_dt_aula date NOT NULL,
    fal_nr_quantidade integer DEFAULT 1 NOT NULL,
    fal_tx_justificativa text,
    fal_tx_codigo_suap varchar(100),
    fal_tx_status bpchar(1) NOT NULL DEFAULT 'A',
    CONSTRAINT fal_falta_pk PRIMARY KEY (fal_nr_id),
    CONSTRAINT fal_matricula_fk FOREIGN KEY (mat_nr_id) REFERENCES academico.mat_matricula_turma(mat_nr_id)
);

CREATE TABLE academico.cht_chat_turma (
    cht_nr_id bigserial NOT NULL,
    tur_nr_id bigint NOT NULL,
    cht_tx_titulo varchar(150),
    cht_tx_status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    cht_dt_criacao timestamp DEFAULT now() NOT NULL,
    CONSTRAINT cht_chat_turma_pk PRIMARY KEY (cht_nr_id),
    CONSTRAINT cht_turma_fk FOREIGN KEY (tur_nr_id) REFERENCES academico.tur_turma(tur_nr_id)
);

CREATE TABLE academico.msg_chat_mensagem (
    msg_nr_id bigserial NOT NULL,
    cht_nr_id bigint NOT NULL,
    usu_nr_id bigint NOT NULL,
    msg_tx_mensagem text NOT NULL,
    msg_dt_envio timestamp DEFAULT now() NOT NULL,
    msg_tx_status bpchar(1) DEFAULT 'A'::bpchar NOT NULL,
    CONSTRAINT msg_chat_mensagem_pk PRIMARY KEY (msg_nr_id),
    CONSTRAINT msg_chat_fk FOREIGN KEY (cht_nr_id) REFERENCES academico.cht_chat_turma(cht_nr_id),
    CONSTRAINT msg_usuario_fk FOREIGN KEY (usu_nr_id) REFERENCES academico.usu_usuario(usu_nr_id)
);

CREATE TABLE academico.int_integracao_suap (
    int_nr_id bigserial NOT NULL,
    int_tx_tipo_importacao varchar(50) NOT NULL,
    int_dt_inicio timestamp DEFAULT now() NOT NULL,
    int_dt_fim timestamp,
    int_tx_status varchar(30) NOT NULL,
    int_tx_mensagem text,
    int_nr_quantidade_registros integer DEFAULT 0,
    CONSTRAINT int_integracao_suap_pk PRIMARY KEY (int_nr_id)
);

CREATE TABLE academico.inl_integracao_suap_log (
    inl_nr_id bigserial NOT NULL,
    int_nr_id bigint NOT NULL,
    inl_tx_entidade varchar(100) NOT NULL,
    inl_tx_registro_suap_id varchar(100),
    inl_tx_operacao varchar(30),
    inl_tx_status varchar(30) NOT NULL,
    inl_tx_mensagem text,
    inl_dt_log timestamp DEFAULT now() NOT NULL,
    CONSTRAINT inl_integracao_suap_log_pk PRIMARY KEY (inl_nr_id),
    CONSTRAINT inl_integracao_fk FOREIGN KEY (int_nr_id) REFERENCES academico.int_integracao_suap(int_nr_id)
);
