---- Login

insert into public.login (nombre_usuario, contraseña, ultimo_ingreso) values ('eduard.arias', '6f453c4718415f600602f6138431c75b', null);
insert into public.login (nombre_usuario, contraseña, ultimo_ingreso) values ('carlos.santana', 'dd91d5fd6326356d9867ab2d03e40e80', null);
insert into public.login (nombre_usuario, contraseña, ultimo_ingreso) values ('jennifer.ivonna', '7fddb1adc2974926af60eaf9842593cb', null);
insert into public.login (nombre_usuario, contraseña, ultimo_ingreso) values ('oswaldo.castillo', '644cde86a469929faf1d7e8717e26c00', null);
insert into public.login (nombre_usuario, contraseña, ultimo_ingreso) values ('francisco.ayala', 'a1697f30207a10b59b79c08d5c9fe77d', null);
insert into public.login (nombre_usuario, contraseña, ultimo_ingreso) values ('sabrina.carpenter', '3a4e53ad2abc9024621e3ae3234e32a9', null);
insert into public.login (nombre_usuario, contraseña, ultimo_ingreso) values ('david.prieto', '3a4e53ad2abc9024621e3ae3234e32a9', null);
insert into public.login (nombre_usuario, contraseña, ultimo_ingreso) values ('admin', '50506ab228e4e112dc5a0d539c07112a', null);

---- Usuario

insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values ('Eduard Arias', 23, 1014297320, 'C', 'eduard.arias@mail.escuelaing.edu.co', 'eduard.arias');
insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values ('Carlos Santana', 33, 173934652, 'C', 'carlos.santana@mail.escuelaing.edu.co', 'carlos.santana');
insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values ('jennifer Ivannova', 27, 117779898, 'C', 'jennifer.ivonna@mail.escuelaing.edu.co', 'jennifer.ivonna');
insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values ('Oswaldo Castillo', 41, 114932294, 'C', 'oswaldo.castillo@escuelaing.edu.co', 'oswaldo.castillo');
insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values ('Francisco Ayala', 28, 158866015, 'C', 'francisco.ayala@mail.escuelaing.edu.co', 'francisco.ayala');
insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values ('Sabrina Carpenter', 23, 151252526, 'C', 'sabrina.carpenter@mail.escuelaing.edu.co', 'sabrina.carpenter');
insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values ('David Prieto', 23, 168137494, 'C', 'david.prieto@mail.escuelaing.edu.co', 'david.prieto');
insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values ('Administrador', 0, 000000000, 'C', 'admin@escuelaing.edu.co', 'admin');

---- Area

insert into public.area_encargada (codigo, nombre) values (120067, 'Ingeniería de Sistemas');

---- Estudiante

insert into public.estudiante (id, tipo_id) values (1014297320, 'C');
insert into public.estudiante (id, tipo_id) values (173934652, 'C');
insert into public.estudiante (id, tipo_id) values (117779898, 'C');
insert into public.estudiante (id, tipo_id) values (158866015, 'C');
insert into public.estudiante (id, tipo_id) values (151252526, 'C');
insert into public.estudiante (id, tipo_id) values (168137494, 'C');

---- 

