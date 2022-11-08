/* cicloergometro.sql: Script para a criação do banco de dados
 * do cicloergometro
 * 
 * Desenvolvedores: Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 *                  Adrian
 * 
 * Data: 18/10/2022
 * Data da última modificação: 07/11/2022
 */

-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.

/* creando o banco de dados */
CREATE DATABASE cicloergometro;

/* usando o banco de dados */
USE cicloergometro;

CREATE TABLE IF NOT EXISTS Enfermeiro (
    login Varchar(8) not null,
    passwd Varchar(8) not null,
    Cod_Enfermeiro int PRIMARY KEY auto_increment not null,
    Especializacao Varchar(150) not null,
    Cod_Profissional int
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS Paciente (
    login Varchar(8) not null,
    passwd Varchar(8) not null,
    CPF Varchar(11) not null,
    Nome Varchar(150) not null,
    Cod_Paciente int PRIMARY KEY  auto_increment not null,
    Telefone Varchar(15) not null,
    sexo Varchar(10)
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS Relatorio_Acompanhamento (
    Data date not null,
    Prontuario int PRIMARY KEY auto_increment not null,
    Hora time not null,
    Descricao Varchar(250),
    Status Varchar(100)
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS Agenda (
    Cod_agendamento int PRIMARY KEY auto_increment not null,
    Data Date,
    Hora Time,
    Retorno Varchar(50),
    Cod_Paciente int,
    Cod_Recepcao int,
    FOREIGN KEY(Cod_Paciente) REFERENCES Paciente (Cod_Paciente)
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS Recepcao (
    Cod_Recepcao int PRIMARY KEY auto_increment not null,
    Nome_Recepcionista Varchar(150),
    Cod_Recepcionista int
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS Fisioterapeuta (
    login Varchar(8) not null,
    passwd Varchar(8) not null,
    Cod_Fisioterapeuta int PRIMARY KEY auto_increment not null,
    Especializacao Varchar(150),
    Cod_Profissional int
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS Profissional_Saude (
    login Varchar(8) not null,
    passwd Varchar(8) not null,
    Nome Varchar(150),
    Cod_Profissional int PRIMARY KEY auto_increment not null,
    Cod_Recepcao int,
    FOREIGN KEY(Cod_Recepcao) REFERENCES Recepcao (Cod_Recepcao)
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS Endereco (
    Cod_Endereco int PRIMARY KEY auto_increment not null,
    Logradouro Varchar(200) not null,
    Numero Varchar(4) not null,
    Cidade Varchar(150) not null,
    Bairo Varchar(150) not null
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS encaminha_monitoramento (
    Cod_Profissional int,
    Prontuario int,
    Cod_Monitoramento int PRIMARY KEY auto_increment not null,
    FOREIGN KEY(Cod_Profissional) REFERENCES Profissional_Saude (Cod_Profissional),
    FOREIGN KEY(Prontuario) REFERENCES Relatorio_Acompanhamento (Prontuario)
) DEFAULT charset = utf8;

CREATE TABLE IF NOT EXISTS Consulta (
    Cod_Consulta int PRIMARY KEY auto_increment not null,
    DtaConsulta date,
    Cod_Paciente int,
    Cod_agendamento int,
    Cod_Profissional int,
    FOREIGN KEY(Cod_Paciente) REFERENCES Paciente (Cod_Paciente),
    FOREIGN KEY(Cod_agendamento) REFERENCES Agenda (Cod_agendamento),
    FOREIGN KEY(Cod_Profissional) REFERENCES Profissional_Saude (Cod_Profissional)
) DEFAULT charset = utf8;

ALTER TABLE Enfermeiro ADD FOREIGN KEY(Cod_Profissional) REFERENCES Profissional_Saude (Cod_Profissional);
ALTER TABLE Agenda ADD FOREIGN KEY(Cod_Recepcao) REFERENCES Recepcao (Cod_Recepcao);
ALTER TABLE Fisioterapeuta ADD FOREIGN KEY(Cod_Profissional) REFERENCES Profissional_Saude (Cod_Profissional);

INSERT INTO Paciente(login, passwd, CPF, Nome, Telefone, sexo) VALUES ('jose', '123', '123456789101', 'Jose','+551136869654','M');
INSERT INTO Fisioterapeuta(login, passwd, Especializacao) VALUES('fisio', '123', 'especializacao');