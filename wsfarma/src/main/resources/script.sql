drop table cliente if exists;
drop table pedido if exists;
drop table pedidoDetalle if exists;
drop table producto if exists;

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

create table pedido(
	numero integer primary key,
	dniCliente varchar(8),
	fecha varchar(10),
	estadoPedido int,
	subImporte double,
	importeFinal double
);

create table pedidoDetalle(
	numeroPedido integer,
	itemPedido integer,
	codigoProducto char(8),
	cantidad integer,
	importe double,
	total double,
);

create table producto(
	codigo char(8) primary key,
	descripcion varchar(50),
	unidMedida varchar(3),
	precio double,
);

insert into producto values ('P0000001', 'Aspirina x 500 mg', 'BLI', 5.00);
insert into producto values ('P0000002', 'Panadol', 'UND', 1.00);
insert into producto values ('P0000003', 'Jarabe para la tos', 'FRA', 15.30);
insert into producto values ('P0000004', 'Jabón Lifebuoy', 'UND', 8.50);
insert into producto values ('P0000005', 'Hisaler', 'BLI', 20.00);
insert into producto values ('P0000006', 'Pankreoflat', 'BLI', 7.40);
insert into producto values ('P0000007', 'Antalgina', 'UND', 0.90);
insert into producto values ('P0000008', 'Icy Hot', 'UND', 18.00);
insert into producto values ('P0000009', 'Buscapina', 'BLI', 6.00);
insert into producto values ('P0000010', 'Hepamaxx', 'BLI', 5.00);
insert into producto values ('P0000011', 'Higanatur', 'BLI', 4.50);
insert into producto values ('P0000012', 'Novalgina', 'BLI', 9.00);
insert into producto values ('P0000013', 'Shampoo Clear Men','BTL' , 16.50);
insert into producto values ('P0000014', 'Enjuague Listerine','BTL', 22.00);
insert into producto values ('P0000015', 'Excedrin Migraña', 'BLI', 10.00);
