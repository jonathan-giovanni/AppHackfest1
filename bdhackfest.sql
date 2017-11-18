create database hackaton17;
use hackaton17;
create table admin(
	id_admin varchar(250) primary key,
	nombre varchar(250) not null,
	pass varchar(250) not null,
	telefono varchar(250),
	dui varchar(250) not null,
	cargo varchar(250)
);

create table usuario(
	id_user varchar(250) primary key,
	nombre varchar(250) not null,
	pass varchar(250) not null,
	telefono varchar(250)
);

create table proceso(
	id_proceso varchar(250) primary key,
	estado varchar(250) not null,
	descripcion_estado text not null,
	fecha_actualizacion datetime not null
);

create table denuncia(
	id_denun varchar(250) primary key,
	titulo varchar(250) not null,
	contenido text not null,
	establecimiento varchar(250) not null,
	fechahora_denuncia datetime not null,
	fechahora_sys datetime not null,
	persona_encargada varchar(250),
	cargo_persona varchar(250),
	direccion text not null,
	id_user varchar(250) not null,
	id_proceso varchar(250) not null,
	FOREIGN KEY (id_user) REFERENCES usuario (id_user),
	FOREIGN KEY (id_proceso) REFERENCES proceso (id_proceso)
);

insert into admin values ('gabriela260894@gmail.com', 'Gabriela Rivera', 'Prueba', '70000000', '05582706-7', 'Jefe' );

insert into usuario values ('egarcia97.r@gmail.com', 'Ernesto  García ', 'Prueba', '70000000'), 
('jonatanvasquez@gmail.com', 'Jonatan Vasquez', 'Prueba', '70000000'),
('dimasgarcia@gmail.com', 'Dimas Garcia', 'Prueba', '70000000');


insert into proceso values(concat('egarcia97.r@gmail.com', now()), 'Pendiente', 'Aún no ha sido verificado tu dununcia',now());
insert into proceso values(concat('egarcia97.r@gmail.com', now()), 'Procesado', 'Tu denuncia está siendo evaluada',now());
insert into proceso values(concat('jonatanvasquez@gmail.com', now()), 'Procesado', 'Tu denuncia está siendo evaluada',now());
insert into proceso values(concat('jonatanvasquez@gmail.com', now()), 'Finalizada', 'Tu denuncia tuvo una respuesta favorable',now());
insert into proceso values(concat('dimasgarcia@gmail.com', now()), 'Procesado', 'Tu denuncia está siendo evaluada',now());
insert into proceso values(concat('dimasgarcia@gmail.com', now()), 'Finalizada', 'Tu denuncia tuvo una respuesta favorable',now());


insert into denuncia values (concat('egarcia97.r@gmail.com', now()),'Denuncia1', 'Inter malo', 'Casa tomada', now(), now(),'Fulano', 'Gerente', 'colonia', 'egarcia97.r@gmail.com','egarcia97.r@gmail.com2017-11-18 12:14:36');
insert into denuncia values(concat('egarcia97.r@gmail.com', now()),'Denuncia1', 'Inter malo', 'Casa tomada', now(), now(),'Fulano', 'Gerente', 'colonia', 'egarcia97.r@gmail.com','egarcia97.r@gmail.com2017-11-18 12:14:39');
insert into denuncia values(concat('jonatanvasquez@gmail.com', now()),'Denuncia2', 'Inter pesimo', 'Casa tomada', now(), now(),'Fulano', 'Gerente', 'colonia', 'jonatanvasquez@gmail.com','jonatanvasquez@gmail.com2017-11-18 12:14:43');
insert into denuncia values(concat('jonatanvasquez@gmail.com', now()),'Denuncia2', 'Inter favorable', 'Casa tomada', now(), now(),'Fulano', 'Gerente', 'colonia', 'jonatanvasquez@gmail.com','jonatanvasquez@gmail.com2017-11-18 12:14:46');
insert into denuncia values(concat('dimasgarcia@gmail.com', now()),'Denuncia3', 'Comida mala', 'Anthonys', now(), now(),'Fulano', 'Gerente', 'colonia', 'dimasgarcia@gmail.com','dimasgarcia@gmail.com2017-11-18 12:14:48');
insert into denuncia values(concat('dimasgarcia@gmail.com', now()),'Denuncia3', 'Comida buena', 'Anthonys', now(), now(),'Fulano', 'Gerente', 'colonia', 'dimasgarcia@gmail.com','dimasgarcia@gmail.com2017-11-18 12:14:51');
