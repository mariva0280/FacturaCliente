create table facturas(
    codFra INT PRIMARY KEY,
    total DOUBLE,
    mes VARCHAR(50) NOT NULL,
    anyo INT NOT NULL,
    clienteDni CHAR(9) NOT NULL,
    FOREIGN KEY (clienteDni) REFERENCES clientes (dni)
);