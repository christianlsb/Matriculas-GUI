CREATE TABLE IF NOT EXISTS aluno (
	id int not null auto_increment,
    nomeCompleto varchar(155) not null,
    idade int not null,
    email varchar(155) not null,
    endereco varchar(155) not null,
    cep varchar(9),
    telefone varchar(15),
    usuario varchar(40) not null,
    senha varchar(155) not null,
    curso varchar(60) not null,
    observacoes varchar(500),
    ativo tinyint not null,
    primary key(id)
);