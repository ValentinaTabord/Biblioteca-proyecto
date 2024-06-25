create database biblioteca;

USE biblioteca;

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    editorial VARCHAR(255),
    anio_publicacion INT,
    isbn VARCHAR(13) UNIQUE NOT NULL
);


CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE libros_categorias (
    libro_id INT,
    categoria_id INT
);

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(15)
);

CREATE TABLE Prestamos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libro_id INT,
    usuario_id INT,
    fecha_prestamo  VARCHAR(15),
    fecha_devolucion VARCHAR(15),
    FOREIGN KEY (libro_id) REFERENCES libros(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

select * from prestamos; 

