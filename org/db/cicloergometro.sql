/* clinicaMedica.sql: Script para a criação do banco de dados
 * para uma clinica medica
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data: 18/10/2022
 * Data da última modificação: 25/10/2022
 */

/* creando o banco de dados */
create database cicloergometro;

/* usando o banco de dados */
use cicloergometro;

/* Tabela que representa um endereço */
create table if not exists Endereco(
	enderecoID int not null auto_increment,
	logradouro varchar(30) not null, # rua
	bairro varchar(30) not null,
	CEP varchar(9) not null,
	numero int not null,
	cidade varchar(15) not null,
	UF enum('AC', 'AL', 'AP', 'AM',
            'BA', 'CE', 'DF', 'ES',
            'GO', 'MA', 'MT', 'MS',
            'MG', 'PA', 'PB', 'PR',
            'PE', 'PI', 'RJ', 'RN',
            'RS', 'RO', 'RR', 'SC',
            'SP', 'SE', 'TO') not null,
	complemento varchar(20),
    primary key(enderecoID)
) default charset = utf8;

/* Tabela que representa o medico */
create table if not exists Medico(
	cod_medico int not null auto_increment,
    enderecoID int,
	nome varchar(50) not null,
    login varchar(8) not null,
    passwd varchar(8) not null,
	RG varchar(12) unique,
	CPF varchar(14) unique not null,
    CRM varchar(6) unique not null,
	sexo enum('M', 'F') not null,
	telefone varchar(14),
	email varchar(25),
	dataNascimento date not null,
    especialidade varchar(25) not null,
    primary key(cod_medico),
    foreign key(enderecoID) references Endereco(enderecoID)
) default charset = utf8;
/*
create table if not exists Consulta(
	data_consulta ;
)
*/
/* Tabela que representa um enfermeiro */
create table if not exists Enfermeiro(
	cod_enfermeiro int not null auto_increment,
    enderecoID int,
	nome varchar(50) not null,
    login varchar(8) not null,
    passwd varchar(8) not null,
	RG varchar(12) unique,
	CPF varchar(14) unique not null,
	sexo enum('M', 'F') not null,
	telefone varchar(14),
	email varchar(25),
	dataNascimento date not null,
	especialidade varchar(25) not null,
    primary key(cod_enfermeiro),
    foreign key(enderecoID) references Endereco(enderecoID)
) default charset = utf8;

/* Tabela que representa um fisioterapeuta */
create table if not exists Fisioterapeuta(
	cod_fisioterapeuta int not null auto_increment,
    enderecoID int,
	nome varchar(50) not null,
    login varchar(8) not null,
    passwd varchar(8) not null,
	RG varchar(12) unique,
	CPF varchar(14) unique not null,
	sexo enum('M', 'F') not null,
	telefone varchar(14),
	email varchar(25),
	dataNascimento date not null,
	especialidade varchar(25) not null,
    primary key(cod_fisioterapeuta),
    foreign key(enderecoID) references Endereco(enderecoID)
) default charset = utf8;

/* Tabela representando o paciente */
create table if not exists Paciente(
	cod_paciente int not null auto_increment,
    enderecoID int,
    nome varchar(50) not null,
    login varchar(8) not null,
    passwd varchar(8) not null,
	CPF varchar(14) unique not null,
	sexo enum('M', 'F') not null,
	peso decimal(4, 2) not null,
	altura decimal(3, 2) not null,
	telefone varchar(14) not null,
	email varchar(25),
	dataNascimento date not null,
	primary key(cod_paciente),
    foreign key(enderecoID) references Endereco(enderecoID)
) default charset = utf8;

create table if not exists Agenda(
	cod_agendamento int,
    dat date,
    hora timestamp default current_timestamp,
	primary key(agendaID)
) default charset = utf8;

create table if not exists Prontuario(

) default charset = utf8;

create table if not exists RelatorioAgendamento(
	dat date,
    hora timestamp default current_timestamp,
	descricao varchar(51),
	stat varchar(25)
) default charset = utf8;
