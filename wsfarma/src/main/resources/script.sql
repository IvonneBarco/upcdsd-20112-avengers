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
	fecha varchar(8),
	dniCliente varchar(8),
	subImporte double,
	importeFinal double
);

create table pedidoDetalle(
	num_pedido integer,
	itempedido integer,
	codproducto char(8),
	cantidad integer,
	precio double,
	total double,
);

create table producto(
	codigo char(8) primary key,
	descripcion varchar(50),
	unidMedida varchar(3),
	precio double,
);

insert into cliente(DNI,nombre) values('42587813','MARCELO MOTTA');
insert into cliente(DNI,nombre) values('42543244','PETROVICH GIL OMARIA');
insert into cliente(DNI,nombre) values('41232333','MOTTA PAOLA');
insert into cliente(DNI,nombre) values('16473848','GIANLUCA BRUNO');
insert into cliente(DNI,nombre) values('48274823','DODORIAN FREEZER');
insert into cliente(DNI,nombre) values('12343434','CAPSULA GOKU');

insert into pedido values (1,'26082011','42587813',4.15,4.15);
insert into pedido values (2,'26082011','42543244',8.50,8.50);
insert into pedido values (3,'26082011','41232333',20.22,20.22);
insert into pedido values (4,'26082011','16473848',100.00,100.00);
insert into pedido values (5,'26082011','48274823',55.98,55.98);
insert into pedido values (6,'26082011','12343434',78.50,78.50);

insert into pedidoDetalle values(1,1,'P0000001',1,5.00,5.00);
insert into pedidoDetalle values(1,2,'P0000002',2,1.00,2.00);
insert into pedidoDetalle values(2,1,'P0000005',1,5.00,5.00);
insert into pedidoDetalle values(2,2,'P0000006',1,7.40,7.40);
insert into pedidoDetalle values(2,3,'P0000008',1,18.00,18.00);
insert into pedidoDetalle values(2,4,'P0000009',2,6.00,12.00);
insert into pedidoDetalle values(3,1,'P0000013',1,16.50,16.50);
insert into pedidoDetalle values(4,1,'P0000006',1,7.40,7.40);
insert into pedidoDetalle values(5,1,'P0000015',1,10.00,10.00);
insert into pedidoDetalle values(6,1,'P0000002',1,1.00,1.00);

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
