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
	importeFinal double,
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

insert into cliente values('43113358', 'Juan Perez', 'Av. Avenida 123', '2108989', 'San Isidro', 'mail@mail.com', '', 'abc');
insert into cliente values('08065525', 'Elsa Pito', 'Jr. Chancay 500', '4278101', 'Cercado', 'mail@correo.com', '', '12346');
insert into cliente values('11155587', 'Armando Kempes', 'Ca. Dean Valdivia 189', '5219696', 'San Isidro', 'mail@hotmail.com', '', '111abc');
insert into cliente values('35647742', 'Jose Diaz', 'Av. Iquitos 471', '992074533', 'La Victoria', 'mail@gmail.com', '',  'inicio');
insert into cliente values('42333151', 'Steve Rogers', 'Av. El Polo 898', '988444555', 'Surco', 'mail@mail.com', '', 'abc');
insert into cliente values('22349988', 'Tony Stark', 'Las Casuarinas 777', '936366100', 'La Molina', 'mail@stark.com', '', '222');
insert into cliente values('06555587', 'Bruce Banner', 'Av. Javier Prado Oeste 601', '3780022', 'Magdalena', 'micorreo@mail.com', '', '147');

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

insert into pedido values(1, '43113358', '02-10-2011', 0, 8.00, 8.00);
insert into pedido values(2, '08065525', '06-09-2011', 1, 31.30, 31.30);
insert into pedido values(3, '11155587', '15-09-2011', 1, 16.50, 16.50);
insert into pedido values(4, '11155587', '02-10-2011', 0, 40.00, 40.00);
insert into pedido values(5, '35647742', '25-09-2011', 0, 5.00, 5.00);
insert into pedido values(6, '42333151', '01-10-2011', 1, 27.10, 27.10);
insert into pedido values(7, '42333151', '02-10-2011', 0, 10.00, 10.00);
insert into pedido values(8, '22349988', '18-09-2011', 0, 9.00, 9.00);
insert into pedido values(9, '06555587', '04-09-2011', 1, 29.00, 29.00);

insert into pedidoDetalle values(1, 1, 'P0000001', 1, 5.00, 5.00);
insert into pedidoDetalle values(1, 2, 'P0000002', 3, 1.00, 3.00);
insert into pedidoDetalle values(2, 1, 'P0000010', 2, 5.00, 10.00);
insert into pedidoDetalle values(2, 2, 'P0000003', 1, 15.30, 15.30);
insert into pedidoDetalle values(2, 3, 'P0000009', 1, 6.00, 6.00);
insert into pedidoDetalle values(3, 1, 'P0000013', 1, 16.50, 16.50);
insert into pedidoDetalle values(4, 1, 'P0000008', 1, 18.00, 18.00);
insert into pedidoDetalle values(4, 2, 'P0000014', 1, 22.00, 22.00);
insert into pedidoDetalle values(5, 1, 'P0000002', 5, 1.00, 5.00);
insert into pedidoDetalle values(6, 1, 'P0000004', 2, 8.50, 17.00);
insert into pedidoDetalle values(6, 2, 'P0000006', 1, 7.40, 7.40);
insert into pedidoDetalle values(6, 3, 'P0000007', 3, 0.90, 2.70);
insert into pedidoDetalle values(7, 1, 'P0000015', 1, 10.00, 10.00);
insert into pedidoDetalle values(8, 1, 'P0000011', 2, 4.50, 9.00);
insert into pedidoDetalle values(9, 1, 'P0000005', 1, 20.00, 20.00);
insert into pedidoDetalle values(9, 2, 'P0000012', 1, 9.00, 9.00);
