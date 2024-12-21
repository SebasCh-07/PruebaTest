drop table if exists reservas;
drop table if exists rutas;
drop table if exists usuarios;
drop table if exists buses;

create table buses (
	id_bus varchar(10) not null,
	capacidad_max int not null,
	constraint buses_pk primary key (id_bus)
);

insert into buses (id_bus, capacidad_max)
values ('B01', 38);
insert into buses (id_bus, capacidad_max)
values ('B02', 38);
insert into buses (id_bus, capacidad_max)
values ('B03', 42);
insert into buses (id_bus, capacidad_max)
values ('B04', 40);
insert into buses (id_bus, capacidad_max)
values ('B05', 45);

select * from buses;

create table usuarios (
	id_persona varchar(10) not null,
	nombre varchar(100) not null,
	apellido varchar(100) not null,
	correo varchar(100) not null,
	telefono varchar(20) not null,
	constraint usuarios_pk primary key (id_persona)
);

insert into usuarios (id_persona, nombre, apellido, correo, telefono)
values('1723456809', 'Alex', 'Matta', 'alex@gmail.com', '0987654321');
insert into usuarios (id_persona, nombre, apellido, correo, telefono)
values('0978645312', 'Alejandra', 'Montes', 'amontes@outlook.com', '0987612344');
insert into usuarios (id_persona, nombre, apellido, correo, telefono)
values('1790864532', 'Maria', 'Armijos', 'mariaC@gmail.com', '0905387438');
insert into usuarios (id_persona, nombre, apellido, correo, telefono)
values('1708965432', 'Leonardo', 'Pesantez', 'leop21@gmail.com', '0953795233');
insert into usuarios (id_persona, nombre, apellido, correo, telefono)
values('1742356980', 'Roberto', 'Carlos', 'crpo32@gmail.com', '0914984239');

select * from usuarios;

create table rutas (
	codigoR varchar(10) not null,
	origen varchar(100) not null,
	destino varchar(100) not null,
	horario_salida TIMESTAMP not null,
	bus varchar(10) not null,
	constraint rutas_pk primary key (codigoR),
	constraint rutas_buses_fk foreign key (bus)
	references buses (id_bus)
);

insert into rutas (codigoR, origen, destino, horario_salida, bus)
values('R001', 'Quito', 'Santo Domingo', '2024/12/21 08:00:00', 'B02');
insert into rutas (codigoR, origen, destino, horario_salida, bus)
values('R002', 'Quito', 'Ambato', '2024/12/21 09:00:00', 'B05');
insert into rutas (codigoR, origen, destino, horario_salida, bus)
values('R003', 'Quito', 'Guayaquil', '2024/12/24 08:00:00', 'B04');
insert into rutas (codigoR, origen, destino, horario_salida, bus)
values('R004', 'Quito', 'Machala', '2024/12/24 13:00:00', 'B01');
insert into rutas (codigoR, origen, destino, horario_salida, bus)
values('R005', 'Quito', 'Esmeraldas', '2024/12/23 06:00:00', 'B03');

select * from rutas; 


create table reservas (
	codigo_reserva varchar(10) not null,
	usuario_re varchar(10) not null,
	boletos int not null,
	ruta varchar(10) not null,
	fecha_reserva TIMESTAMP not null,
	constraint reservas_pk primary key (codigo_reserva),
	constraint reservas_usuario_fk foreign key (usuario_re)
	references usuarios (id_persona),
	constraint reservas_ruta_fk foreign key (ruta)
	references rutas (codigoR)
);

insert into reservas (codigo_reserva, usuario_re, boletos, ruta, fecha_reserva)
values ('RE01', '1723456809', 2, 'R002', '2024/11/21 13:45:00');
insert into reservas (codigo_reserva, usuario_re, boletos, ruta, fecha_reserva)
values ('RE02', '1790864532', 4, 'R002', '2024/12/01 07:34:00');
insert into reservas (codigo_reserva, usuario_re, boletos, ruta, fecha_reserva)
values ('RE03', '0978645312', 3, 'R004', '2024/12/04 16:05:00');
insert into reservas (codigo_reserva, usuario_re, boletos, ruta, fecha_reserva)
values ('RE04', '1742356980', 5, 'R003', '2024/11/29 18:55:00');
insert into reservas (codigo_reserva, usuario_re, boletos, ruta, fecha_reserva)
values ('RE05', '1708965432', 2, 'R001', '2024/11/26 09:05:00');

select * from reservas; 


