CREATE DATABASE TiendaDisco;

USE TiendaDisco;

CREATE TABLE USUARIO(                            
Email Varchar(50) NOT NULL,
Contraseña VARCHAR(50) NOT NULL,
Nombre Varchar(45) NOT NULL,
Gustos VARCHAR(50) NOT NULL,
PRIMARY KEY(Email));

CREATE TABLE CANCION(                            
IdCancion int AUTO_INCREMENT NOT NULL,
Nombre Varchar(45) NOT NULL,
Duracion int NOT NULL,
IdDisco int NOT NULL,
PRIMARY KEY(IdCancion));

CREATE TABLE ARTISTA(                            
NombreA Varchar(50) NOT NULL,
Trayectoria VARCHAR(50) NOT NULL,
NombreR Varchar(45) NOT NULL,
PRIMARY KEY(NombreA));

CREATE TABLE DISCO(                            
IdDisco Int NOT NULL,
Nombre VARCHAR(50) NOT NULL,
Genero Varchar(45) NOT NULL,
NoCanciones VARCHAR(50) NOT NULL,
Nombre_A varchar(50) NOT NULL,
NombreDis varchar(50) NOT NULL,
foreign key (Nombre_A) references ARTISTA(NombreA),
PRIMARY KEY(IdDisco));

CREATE TABLE DISQUERA(                            
NombreD Varchar(50) NOT NULL,
DirCiudad VARCHAR(50) NOT NULL,
DirPais Varchar(45) NOT NULL,
PRIMARY KEY(NombreD));