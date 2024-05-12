CREATE DATABASE aps;

USE aps;

CREATE TABLE login(
id_login INT PRIMARY KEY AUTO_INCREMENT,
Usuario VARCHAR(255) NOT NULL,
Senha VARCHAR(255) NOT NULL
);


CREATE TABLE pessoa(
id INT PRIMARY KEY AUTO_INCREMENT,
id_login INT,
nome VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
cidade VARCHAR(255) NOT NULL,
rua VARCHAR (255),
id_telefones INT
);



CREATE TABLE telefones(
id INT PRIMARY KEY AUTO_INCREMENT,
id_pessoa INT,
telefone1 VARCHAR(40) NOT NULL,
telefone2 VARCHAR(40)
);



CREATE TABLE patrimonio(
id_patrimonio INT PRIMARY KEY AUTO_INCREMENT,
nome_patrimonio Varchar(255) NOT NULL,
pn  Varchar(255) NOT NULL,
sn  Varchar(255) NOT NULL);


CREATE TABLE chamados(
id INT PRIMARY KEY AUTO_INCREMENT,
id_pessoa INT,
FOREIGN KEY(id_pessoa) REFERENCES pessoa(id),
descricao TEXT NOT NULL,
dt_abertura DATE DEFAULT (DATE(NOW())),
estado varchar(40) NOT NULL
);

ALTER TABLE patrimonio ADD FOREIGN KEY(id_pessoa) REFERENCES pessoa(id);

ALTER TABLE pessoa ADD FOREIGN KEY(id_login) REFERENCES login(id);

ALTER TABLE pessoa ADD FOREIGN KEY(id_telefones) REFERENCES telefones(id);
