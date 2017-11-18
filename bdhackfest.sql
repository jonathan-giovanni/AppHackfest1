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
	pass varchar(250)
);

create table denuncia(
	id_denun varchar(250) primary key,
	titulo varchar(250),
	contenido text,
	establecimiento varchar(250),
	fechahora datetime,
	persona_encargada varchar(250),
	direccion text,
	id_user varchar(250)
	FOREIGN KEY (id_user) REFERENCES usuario (id_user)
);
