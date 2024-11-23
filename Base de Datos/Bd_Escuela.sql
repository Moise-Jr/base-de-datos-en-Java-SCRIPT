/*insertar*/
insert into alumnos (nombres,apellidos,edad,telefono,direccion) values ('moises','diaz','33','3104899717','boston');

/*mostrar*/
select * from Alumnos;

/*actualizar*/
update Alumnos set alumnos.nombres='carlos',alumnos.apellidos='gonzalez',alumnos.edad='34',alumnos.telefono='3104899718',alumnos.direccion='boston1' WHERE alumnos.dni=1;

/*eliminar*/
DELETE FROM alumnos WHERE alumnos.dni=2;