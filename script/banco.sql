create database dm20231n;

create table dm20231n.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));
  
create table dm20231n.pessoas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  cpf VARCHAR(255),
  tipo VARCHAR(255),
  email VARCHAR(255),
  primary key (id));

create table dm20231n.logradouros (
  id BIGINT NOT NULL AUTO_INCREMENT,
  cep VARCHAR(255),
  numero VARCHAR(255),
  compl VARCHAR(255),
  primary key (id));

create table dm20231n.pessoas_logradouros (
  id BIGINT NOT NULL AUTO_INCREMENT,
  id_p BIGINT NOT NULL,
  id_l BIGINT NOT NULL,
  obs VARCHAR(255),
  primary key (id));

INSERT INTO `dm20231n`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('BITTENCOURT', 'ABFABF010101', 'ATIVO', 'ADM');
INSERT INTO `dm20231n`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('SCURACCHIO', 'ABFABF010101', 'ATIVO', 'VISITANTE');


