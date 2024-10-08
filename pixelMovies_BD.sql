DROP DATABASE IF EXISTS pixelmovies_bd;
CREATE DATABASE pixelmovies_bd;
use pixelmovies_bd;

DROP TABLE IF EXISTS CLIENTES;
CREATE TABLE CLIENTES (
    ID_CLIENTE INT AUTO_INCREMENT PRIMARY KEY,
    DNI_CLIENTE VARCHAR(20) NOT NULL,
    NOMBRES_CLIENTE VARCHAR(100) NOT NULL,
    APELLIDO_PAT_CLIENTE VARCHAR(100) NOT NULL,
    APELLIDO_MAT_CLIENTE VARCHAR(100) NOT NULL,
    NUM_CELULAR_CLIENTE VARCHAR(15),
    FECHA_NACIMIENTO_CLIENTE DATE,
    CORREO_CLIENTE VARCHAR(100)
);

DROP TABLE IF EXISTS SALAS;
CREATE TABLE SALAS (
	ID_SALA INT AUTO_INCREMENT PRIMARY KEY,
    COD_SALA VARCHAR(7) NOT NULL,
    CAPACIDAD_SALA INT NOT NULL
);

DROP TABLE IF EXISTS PELICULAS;
CREATE TABLE PELICULAS (
	ID_PELICULAS INT AUTO_INCREMENT PRIMARY KEY,
	NOMBRE_PELICULA VARCHAR (50)	NOT NULL,
    DIRECTOR_PELI VARCHAR (50)	NOT NULL,
    GENERO_PELI VARCHAR (30)	NOT NULL,
    DURACION_PELI TIME NOT NULL,
    IDIOMA_PELI VARCHAR (30) NOT NULL,
    CLASIFICACION_PELI VARCHAR (50)	NOT NULL
);

DROP TABLE IF EXISTS PRODUCTOS;
CREATE TABLE PRODUCTOS (
	ID_PRODUCTO	INT	AUTO_INCREMENT PRIMARY KEY, 
	NOMBRE_PRODUCTO	VARCHAR (100)	NOT NULL,
	PRECIO_PRODUCTO	DECIMAL (8,2)	NOT NULL,
	MARCA_PRODUCTO VARCHAR (30)		NULL
);

DROP TABLE IF EXISTS EMPLEADOS;
CREATE TABLE EMPLEADOS (
	ID_EMPLEADO INT AUTO_INCREMENT PRIMARY KEY,
    DNI_EMPLEADO VARCHAR(20) NOT NULL,
    NOMBRES_EMPLEADO VARCHAR(100) NOT NULL,
    APELLIDO_PAT_EMPLEADO VARCHAR(100) NOT NULL,
    APELLIDO_MAT_EMPLEADO VARCHAR(100) NOT NULL,
    NUM_CELULAR_EMPLEADO VARCHAR(15),
    FECH_NACIMIENTO_EMPLEADO DATE,
    CORREO_EMPLEADO VARCHAR(100)
);

DROP TABLE IF EXISTS RESERVAS;
CREATE TABLE RESERVAS (
    ID_RESERVA INT AUTO_INCREMENT PRIMARY KEY,
    ID_CLIENTE INT,
    ID_SALA INT,
    FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES(ID_CLIENTE) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ID_SALA) REFERENCES SALAS(ID_SALA) ON DELETE CASCADE ON UPDATE CASCADE
);

/*INSERTOS EN CLIENTES*/
INSERT INTO CLIENTES (DNI_CLIENTE, NOMBRES_CLIENTE, APELLIDO_PAT_CLIENTE, APELLIDO_MAT_CLIENTE, NUM_CELULAR_CLIENTE, FECHA_NACIMIENTO_CLIENTE, CORREO_CLIENTE)
VALUES ('1234567', 'Juan', 'Perez', 'Sanchez', '999486261', '2002-10-07', 'juan.perez@gmail.com');
INSERT INTO CLIENTES (DNI_CLIENTE, NOMBRES_CLIENTE, APELLIDO_PAT_CLIENTE, APELLIDO_MAT_CLIENTE, NUM_CELULAR_CLIENTE, FECHA_NACIMIENTO_CLIENTE, CORREO_CLIENTE)
VALUES ('2345678', 'Maria', 'Sanchez', 'Gimenez', '975203649', '2003-05-14', 'maria.geminis@gmail.com');

/*INSERTOS EN SALAS*/
INSERT INTO SALAS (COD_SALA, CAPACIDAD_SALA) VALUES ('SALA001', 50);
INSERT INTO SALAS (COD_SALA, CAPACIDAD_SALA) VALUES ('SALA002', 50);

/*INSERTOS EN PELICULAS*/
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('Spider-Man: No Way Home', 'Jon Watts', 'Superhéroes', '02:28:00', 'Español', 'ATP');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('El Gran Escape', 'John Sturges', 'Aventura', '02:52:00', 'Español', 'ATP');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('El Padrino', 'Francis Ford Coppola', 'Drama', '02:55:00', 'Inglés/Español', 'PG-13');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('La La Land', 'Damien Chazelle', 'Musical', '02:08:00', 'Español', 'ATP');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('El Señor de los Anillos: La Comunidad del Anillo', 'Peter Jackson', 'Fantasía', '02:58:00', 'Español', 'PG-13');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('Titanic', 'James Cameron', 'Drama', '03:15:00', 'Español', 'PG-13');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('La Lista de Schindler', 'Steven Spielberg', 'Drama', '03:15:00', 'Español', 'PG-13');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('Jurassic Park', 'Steven Spielberg', 'Ciencia ficción', '02:07:00', 'Español', 'PG-13');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('El Caballero Oscuro', 'Christopher Nolan', 'Acción/Crimen/Drama', '02:32:00', 'Español', 'PG-13');
INSERT INTO PELICULAS (NOMBRE_PELICULA, DIRECTOR_PELI, GENERO_PELI, DURACION_PELI, IDIOMA_PELI, CLASIFICACION_PELI)
VALUES ('El Rey León', 'Roger Allers y Rob Minkoff', 'Animación - Musical - Drama', '01:28:00', 'Español', 'ATP');

/*INSERTOS EN PRODUCTOS*/
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Popcorn tamaño grande', 27.00, 'Orville Redenbacher');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Gaseosa vaso grande', 6.50, 'Inka Cola');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Gaseosa vaso chico', 3.50, 'Coca Cola');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Café', 5.00, 'Dell');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Popcorn tamaño mediano', 20.00, 'Orville Redenbacher');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Hot Dog', 14.50, 'Oscar Mayer');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Nachos con queso', 10.00, 'Tostitos');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Pretzels', 7.30, 'Rold Gold');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Papas fritas', 12.10, 'Pringles');
INSERT INTO PRODUCTOS (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, MARCA_PRODUCTO) VALUES ('Dulces', 5.00, 'Mars');

/*INSERTOS EN EMPLEADOS*/
INSERT INTO EMPLEADOS (DNI_EMPLEADO, NOMBRES_EMPLEADO, APELLIDO_PAT_EMPLEADO, APELLIDO_MAT_EMPLEADO, NUM_CELULAR_EMPLEADO, FECH_NACIMIENTO_EMPLEADO, CORREO_EMPLEADO) 
VALUES ('75368914', 'Andres Ernesto', 'Gallegos', 'Fuentes', '978015610', '1986-08-15', 'andres.gallegos@example.com');
INSERT INTO EMPLEADOS (DNI_EMPLEADO, NOMBRES_EMPLEADO, APELLIDO_PAT_EMPLEADO, APELLIDO_MAT_EMPLEADO, NUM_CELULAR_EMPLEADO, FECH_NACIMIENTO_EMPLEADO, CORREO_EMPLEADO) 
VALUES ('19671345', 'Adriana Angy', 'Montes', 'Aranda', '900855111', '2001-03-20', 'adriana.montes@example.com');
INSERT INTO EMPLEADOS (DNI_EMPLEADO, NOMBRES_EMPLEADO, APELLIDO_PAT_EMPLEADO, APELLIDO_MAT_EMPLEADO, NUM_CELULAR_EMPLEADO, FECH_NACIMIENTO_EMPLEADO, CORREO_EMPLEADO) 
VALUES ('43128756', 'Guillermo Sergio', 'Barrios', 'Huerta', '984268009', '1998-06-10', 'guillermo.barrios@example.com');

SELECT * FROM CLIENTES;
SELECT * FROM SALAS;
SELECT * FROM PELICULAS;
SELECT * FROM PRODUCTOS;
SELECT * FROM EMPLEADOS;
SELECT * FROM RESERVAS;