drop table cliente if exists;
create table cliente(
	DNI varchar(8) primary key,
	nombre varchar(60), 
	direccion varchar(60),
	telefono varchar(9),
	distrito varchar(20),
	email varchar(60),
	flagNotif varchar(1),
	password varchar(20)
);