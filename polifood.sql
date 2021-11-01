CREATE DATABASE POLIFOOD;
DROP DATABASE POLIFOOD;
USE POLIFOOD;

CREATE TABLE Usuarios(
	id INT NOT NULL AUTO_INCREMENT,
    correoInstitucional varchar(50) NOT NULL,
    telefonoCelular varchar(12) NOT NULL,
    contrasenia varchar(10) NOT NULL,
    noBoleta varchar(10) NOT NULL,
    primary key(id)
);

CREATE TABLE DatosPersonales(
	idUsuario_fk int NOT NULL,
    nombre varchar(50) NOT NULL,
    aPaterno varchar(50) NOT NULL,
    aMaterno varchar(50) NOT NULL,
    primary key(idUsuario_fk),
    foreign key(idUsuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE CatalogoSemestre(
	idUsuario_fk int NOT NULL,
    noSemestre int NOT NULL,
    primary key (idUsuario_fk),
    foreign key(idUsuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ProductosUsuario(
	idProducto int NOT NULL AUTO_INCREMENT,
    idUsuario_fk int NOT NULL,
    subida datetime NULL,
    primary key(idProducto), 
    foreign key (idUsuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE DatosProducto(
	idDatos int NOT NULL AUTO_INCREMENT,
    idProducto_fk int NOT NULL,
    nombreProducto varchar(20) NOT NULL,
    precio float NOT NULL,
    descripcion varchar(50) NULL,
    primary key(idDatos),
    foreign key (idProducto_fk) references ProductosUsuario(idProducto) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE OrdenesCompra(
	idCompra int auto_increment,
    fecha datetime NOT NULL,
    idUsuario_fk int NOT NULL,
    cantidad int NOT NULL,
    primary key (idCompra),
    foreign key (idUsuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Ventas(
	idUsuario_fk int, 
    idCompra_fk int,
    mensaje varchar(250) NOT NULL,
    primary key(idCompra_fk),
    foreign key(idCompra_fk) references OrdenesCompra(idCompra) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(idUsuario_fk) references Usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE SolicitudCompra(
	idSolicitud int NOT NULL auto_increment,
    idCompra_fk int NOT NULL,
    idProducto_fk int NOT NULL,
    primary key(idSolicitud),
    foreign key(idCompra_fk) references OrdenesCompra(idCompra) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key(idProducto_fk) references ProductosUsuario(idProducto) ON DELETE CASCADE ON UPDATE CASCADE
);

###Insertar Usuarios

insert into Usuarios(correoinstitucional,telefonoCelular,contrasenia,noBoleta) 
values("dfloresc1602@alumno.ipn.mx","5583350110","Diego","2020640131"),
	  -- ("gserranoh1600@alumno.ipn.mx","5564906807",2020640132),
      ("jaldretea1600@alumno.ipn.mx","5540245363","Jonny","2020640133");
	
insert into DatosPersonales(nombre,aPaterno,aMaterno,idUsuario_fk)
values("Guadalupe Nohemi","Serrano","Hernandez",7),
	  ("Diego","Flores","Chavarria",8),
      ("Jonathan Cesar","Aldrete","Aguado",9);

insert into CatalogoSemestre(no_Semestre,id_usuario_fk)
values(4,1),
	  (4,2),
      (4,3);

insert into ProductosUsuario(subida,idUsuario_fk)
values(now(),7),
	  (now(),8),
      (now(),9);

insert into DatosProducto(nombreProducto,precio,descripcion,idProducto_fk)
values("Torta de Chilaquiles",35.48,"Torta de Chilaquiles Verdes con Pollo para llevar",5),
	  ("Palomitas",20.50,"Palomitas con takis fuego, salsa y limon",6),
      ("Mazapanes",15.50,"Mazapan de la Tia Rosa",7);
      

insert into Edificio(id_Edificio,Nombre_Edificio,Salon) 
values(1,"Edificio-1",102),
	  (2,"Edificio",202),
      (3,"Edificio",303);

insert into Area_Libre(id_Area_Libre,nombre_Area_Libre)
values(2,"Canchas"),
	  (1,"Pasillo Central"),
      (3,"Cafeteria");

insert into OrdenesCompra(idCompra,fecha,idUsuario_fk,cantidad) 
values(1,now(),8,9),
	  (2,now(),8,10),
      (3,now(),9,10);

insert into SolicitudCompra(idProducto_fk,idCompra_fk)
values(3,1,1),
	  (4,2,2),
      (5,3,3);

insert into Ventas(mensaje,id_usuario_fk,id_compra_fk)
values(1,1,1),
	  (1,2,2),
      (1,3,3);

### SELECT
select * from Usuarios where id = (select idUsuario_fk from DatosPersonales where nombre = "Diego");
select Usuarios.*,DatosPersonales.* from Usuarios inner join DatosPersonales on id=idUsuario_fk where nombre = "Diego";
select * from Usuarios;
select * from DatosPersonales;
select * from CatalogoSemestre;
select * from Usuarios;
select * from ProductosUsuario; 
select * from DatosProducto;
select max(idProducto) from ProductosUsuario where idUsuario_fk = (select id from Usuarios where correoInstitucional = "dfloresc1602@alumno.ipn.mx");
select idUsuario_fk from ProductosUsuario where idProducto = (select idProducto_fk from DatosProducto where nombreProducto = "Mazapanes" and idDatos=13);
select max(idCompra) from OrdenesCompra where idUsuario_fk = (select id from Usuarios where correoInstitucional = "dfloresc1602@alumno.ipn.mx");
select * from Edificio;
select * from Area_Libre;
select * from OrdenesCompra;
select * from Solicitud_Compra;
select * from Ventas;

### DELETE


delete from Usuarios;
delete from DatosPersonales;
delete from CatalogoSemestre;
delete from ProductosUsuario;
delete from DatosProducto;

delete from Edificio;
delete from Area_Libre;
delete from OrdenCompra;
delete from Solicitud_Compra;
delete from Ventas;

### UPDATE

update Usuarios set telefono_Celular = '5539093501' where correo_Institucional = 'dfloresc1602@alumno.ipn.mx';
update CatalogoSemestre set no_Semestre = '5' where id_Usuario_fk = 1;
update DatosProducto set Nombre_Producto = 'Torta de Huevo', precio = 23.00, Descripcion = "Torta de huevo a la mexicana" 
where id_Datos = 1;



