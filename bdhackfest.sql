create table admin(
	id_admin varchar(250) primary key,
	nombre varchar(250),
	pass varchar(250),
	telefono varchar(250),
	dui varchar(250),
	cargo varchar(250)
);

create table usuario(
	id_user varchar(250) primary key,
	nombre varchar(250),
	pass varchar(250),
	telefono varchar(250)
);

create table proceso(
	id_proceso varchar(250) primary key,
	estado varchar(250),
	descripcion_estado text,
	fecha_actualizacion datetime
);

create table denuncia(
	id_denun varchar(250) primary key,
	titulo varchar(250),
	contenido text,
	establecimiento varchar(250),
	fechahora datetime,
	persona_encargada varchar(250),
	cargo_persona varchar(250),
	direccion text,
	id_user varchar(250),
	id_proceso varchar(250),
	FOREIGN KEY (id_user) REFERENCES usuario (id_user),
	FOREIGN KEY (id_proceso) REFERENCES proceso (id_proceso)
);



