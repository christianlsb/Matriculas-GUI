CREATE DATABASE IF NOT EXISTS alunos;
USE alunos;

CREATE TABLE IF NOT EXISTS aluno (
	id INT NOT NULL AUTO_INCREMENT,
    nomeCompleto VARCHAR(155) NOT NULL,
    idade INT NOT NULL,
    email VARCHAR(155) NOT NULL,
    endereco VARCHAR(155) NOT NULL,
    cep VARCHAR(9),
    telefone VARCHAR(15),
    usuario VARCHAR(40) NOT NULL,
    senha VARCHAR(155) NOT NULL,
    curso VARCHAR(60) NOT NULL,
    observacoes VARCHAR(500),
    ativo TINYINT NOT NULL,
    PRIMARY KEY(id)
);