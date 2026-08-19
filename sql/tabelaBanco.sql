create table "DDD"(
    nro_ddd int primary key
);

create table "DDI"(
    nro_ddi int primary key
);

create table "FonePaciente"(
    nro_fone_paciente varchar(16),
    nro_ddd int,
    nro_ddi int,
    nro_paciente int not null,
    primary key(nro_fone_paciente, nro_ddd, nro_ddi),
    foreign key (nro_ddd) references "DDD" (nro_ddd),
    foreign key (nro_ddi) references "DDI" (nro_ddi),
    foreign key (nro_paciente) references "Paciente" (nro_paciente)
);

create table "EstadoCivil"(
    id_estado_civil serial primary key,
    descricao_estado_civil varchar(20)
);

create table "Sexo"(
    id_sexo serial primary key,
    descricao_sexo varchar(16)
);

create table "EmailPaciente"(
    id_email_paciente serial primary key,
    endereco_email varchar(32),
    nro_paciente int not null,
    foreign key (nro_paciente) references "Paciente" (nro_paciente)
);

create table "UnidadeFederativa"(
    sigla_uf varchar(3) primary key,
    nome_uf varchar(42)
);

create table "Cidade"(
    id_cidade serial primary key,
    nome_cidade varchar(32),
    sigla_uf varchar(3),
    foreign key (sigla_uf) references "UnidadeFederativa" (sigla_uf)
);

create table "Bairro"(
    id_bairro serial primary key,
    nome_bairro varchar(42)
);

create table "TipoLogradouro"(
    sigla_tipo_logradouro varchar(3) primary key,
    nome_tipo_logradouro varchar(32)
);

create table "Logradouro"(
    id_logradouro serial primary key,
    nome_logradouro varchar(32),
    sigla_tipo_logradouro varchar(3),
    foreign key (sigla_tipo_logradouro) references "TipoLogradouro" (sigla_tipo_logradouro)
);

create table "Endereco"(
    id_endereco serial primary key,
    cep varchar(14),
    id_bairro int not null,
    id_logradouro int not null,
    id_cidade int not null,
    foreign key (id_bairro) references "Bairro" (id_bairro),
    foreign key (id_logradouro) references "Logradouro" (id_logradouro),
    foreign key (id_cidade) references "Cidade" (id_cidade)
);

create table "Paciente"(
    nro_paciente serial primary key,
    nome_paciente varchar(50),
    data_nascimento date,
    doc_identidade varchar(20),
    id_estado_civil int,
    id_sexo int not null,
    id_endereco int not null,
    foreign key (id_estado_civil) references "EstadoCivil" (id_estado_civil),
    foreign key (id_sexo) references "Sexo" (id_sexo),
    foreign key (id_endereco) references "Endereco" (id_endereco)
);

create table "EmailMedico"(
    id_email_medico serial primary key,
    endereco_email varchar(32),
    id_medico int not null,
    foreign key (id_medico) references "Medico" (id_medico)
);

create table "Medico"(
    id_medico serial primary key,
    nome_medico varchar(32),
    crm varchar(16)
);

create table "CID"(
    cod_cid int primary key,
    descricao_cid varchar(26)
);

create table "Consulta"(
    nro_consulta serial primary key,
    data_consulta date,
    id_medico int not null,
    nro_paciente int not null,
    cod_cid int not null,
    foreign key (id_medico) references "Medico" (id_medico),
    foreign key (nro_paciente) references "Paciente" (nro_paciente),
    foreign key (cod_cid) references "CID" (cod_cid)
);

create table "TipoExame"(
    id_tipo_exame int primary key,
    nome_tipo_exame varchar(26)
);

create table "ResultadoExame"(
    id_resultado_exame serial primary key,
    descricao_resultado_exame varchar(26)
);

create table "Exame"(
    nro_exame serial primary key,
    data_exame date,
    observacao_exame varchar(50),
    id_tipo_exame int not null,
    nro_paciente int not null,
    id_medico int,
    id_resultado_exame int,
    foreign key (id_tipo_exame) references "TipoExame" (id_tipo_exame),
    foreign key (nro_paciente) references "Paciente" (nro_paciente),
    foreign key (id_medico) references "Medico" (id_medico),
    foreign key (id_resultado_exame) references "ResultadoExame" (id_resultado_exame)
);

