CREATE DATABASE ingles;

CREATE TABLE usuario (
	cod_usuario INT(10) NOT NULL AUTO_INCREMENT,
	usuario_nome VARCHAR(40) NOT NULL,
	usuario_senha VARCHAR(40) NOT NULL,
	usuario_email VARCHAR(60) NOT NULL,
	PRIMARY KEY (cod_usuario));
	
CREATE TABLE exame (
	ID INT(10) NOT NULL AUTO_INCREMENT,
	cod_usuario INT(10) NOT NULL,
	vlr_nota DOUBLE NOT NULL,
	descr_exame VARCHAR(5) NOT NULL,
	PRIMARY KEY (ID),
	INDEX cod_usuario (cod_usuario),
	FOREIGN KEY (cod_usuario) REFERENCES usuario (cod_usuario);

