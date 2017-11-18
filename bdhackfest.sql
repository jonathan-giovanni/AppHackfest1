create table admin(
	id_admin varchar(250) primary key,
	nombre varchar(250),
	clave varchar(250),
	telefono varchar(250),
	dui varchar(250),
	cargo varchar(250)
);

create table usuario(
	id_user varchar(250) primary key,
	nombre varchar(250),
	contrasenia varchar(250),
);

create table denuncia(
	id_denun integer primary key auto_increment,
	titulo varchar(250),
	contenido varchar(250),
	establecimiento varchar(250),
	fechahora varchar(250),
	persona_encargada varchar(250),
	direccion text,
	id_user varchar(250)
	FOREIGN KEY (codlib) REFERENCES `libro` (`cod_libro`),
);