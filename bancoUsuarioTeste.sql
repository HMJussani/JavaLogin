create database novosistema;

use novosistema;

create table usuarios(
 iduser int primary key auto_increment,
 nome varchar(20) not null,
 login varchar(20)not null unique,
 pass varchar(20)not null

);

describe usuarios;

insert into usuarios(nome, login, pass)values('Administrador', 'admin', 'admin');



-- update usuarios set login = 'admin', pass='admin' where login ='admin' ;