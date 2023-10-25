create table clientes(
    dni char(9) primary key,
    name varchar(200),
    pais varchar(200),
    premium bit(1),
    fechaNac date
);