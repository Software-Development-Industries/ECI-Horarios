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

---- Inscripcion

insert into public.inscripcion (MAX_CREDITOS, id, tipo, fecha_inicio, fecha_final, estudiante_id, estudiante_tipo_id) values (18, 1, 'P', '2000-10-19 00:00:00', '2021-06-19 00:00:00', 1014297320, 'C');
insert into public.inscripcion (MAX_CREDITOS, id, tipo, fecha_inicio, fecha_final, estudiante_id, estudiante_tipo_id) values (9, 1, 'P', '2000-10-19 00:00:00', '2021-06-19 00:00:00', 173934652, 'C');

---- Administrador

insert into public.administrador (id, tipo_id, area_id) values (114932294, 'C', 120067);
insert into public.administrador (id, tipo_id, area_id) values (000000000, 'C', 120067);

---- Materia

insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Algoritmos y Programación', 'AYPR', 'Introducción a la programación básica con el paradigma estructurado', 3, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Algoritmos y Estructuras de Datos', 'AYED', 'Programación de estructuras de datos básicas y avanzadas', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Programación Orientada a Objetos', 'POOB', 'Cambio de paradigma de programación a la de Objetos', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Modelos y Bases de Datos', 'MBDA', 'Introducción al diseño y construcción de bases de datos relacionales', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Ciclos de Vida del Software', 'CVDS', 'Construcción del software junto con las fases de su ciclo de vida', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Arquitectura Computacional y Sistemas Operativos', 'ACSO', 'Detalle de la arquitectura de hardware de un computador Turing junto con las fases del Sistema Operativo', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Redes de Computadores', 'RECO', 'Detalle de los métodos y tecnologías de comunicación entre computadores', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Lógica Calculativa', 'LCAT', 'Introducción a la lógica calculatoria y sistemas formales', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Matemáticas Discretas', 'MATD', 'Relaciona la lógica detrás de las matemáticas en dominios discretos', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Teoría de la Programación', 'TPRO', 'Lógica como herramienta de construcción de software y algoritmos', 3, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Arquitecturas de Software', 'ARSW', 'Desarrollo completo de software basandose en arquitecturas completas', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Arquitecturas Empresariales', 'AREP', 'Software como parte del desarrollo sostenible de un proyecto de tipo empresarial', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Seguridad y Privacidad de TI', 'SPTI', 'Seguridad en los procesos y construcción de las TI', 4, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Teoría de Sistemas y Organizaciones', 'TSOR', 'Descripción del concepto de sistema y su desarrollo junto con otros sistemas', 3, 120067);
insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values ('Automatización de Procesos de Negocio', 'AUPN', 'Desarrollo completo de un proceso empresarial asistido con herramientas de software', 4, 120067);

---- Requisito

insert into public.requisito (materia_id, requisito_id) values ('AYED', 'AYPR');
insert into public.requisito (materia_id, requisito_id) values ('POOB', 'AYED');
insert into public.requisito (materia_id, requisito_id) values ('MATD', 'LCAT');
insert into public.requisito (materia_id, requisito_id) values ('TPRO', 'MATD');
insert into public.requisito (materia_id, requisito_id) values ('CVDS', 'POOB');
insert into public.requisito (materia_id, requisito_id) values ('CVDS', 'MBDA');
insert into public.requisito (materia_id, requisito_id) values ('AUPN', 'TSOR');
insert into public.requisito (materia_id, requisito_id) values ('AUPN', 'POOB');
insert into public.requisito (materia_id, requisito_id) values ('RECO', 'ACSO');
insert into public.requisito (materia_id, requisito_id) values ('ARSW', 'CVDS');
insert into public.requisito (materia_id, requisito_id) values ('AREP', 'AUPN');
insert into public.requisito (materia_id, requisito_id) values ('AREP', 'RECO');
insert into public.requisito (materia_id, requisito_id) values ('AREP', 'CVDS');
insert into public.requisito (materia_id, requisito_id) values ('SPTI', 'RECO');


---- Grupo

insert into public.grupo (cupo, numero_id, materia_id, profesor) values (20, 1, 'AYPR', 'Juanito Perez');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (20, 2, 'AYPR', 'Juanito Perez');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (15, 1, 'AYED', 'Oscar Wilde');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (18, 1, 'ACSO', 'Gerardo Ospina');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (22, 1, 'RECO', 'Claudia Cely');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (20, 2, 'RECO', 'Claudia Cely');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (22, 1, 'SPTI', 'Samuel L. Jackson');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (18, 1, 'AREP', 'Daniel Benavides');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (18, 2, 'AREP', 'Daniel Benavides');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (30, 1, 'ARSW', 'David Prieto');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (18, 1, 'MATD', 'Raul Chaparro');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (18, 2, 'MATD', 'Eduard Arias');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (22, 1, 'AUPN', 'Lorena Castillo');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (22, 1, 'CVDS', 'Pedro Gonzalez Rincón');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (22, 2, 'CVDS', 'Morty Sanchez');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (20, 2, 'AUPN', 'Morty Sanchez');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (15, 2, 'AYED', 'Diego Satoba');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (20, 2, 'ARSW', 'David Prieto');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (25, 1, 'POOB', 'Maria Irma');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (23, 2, 'POOB', 'Maria Irma');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (25, 1, 'MBDA', 'Jose perez');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (23, 1, 'LCAT', 'Juanita de la Concepción');
insert into public.grupo (cupo, numero_id, materia_id, profesor) values (22, 2, 'LCAT', 'Eduard Arias');


---- Fecha grupo

insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Lu', '07:00', '08:30', 1, 'AYPR');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Mi', '07:00', '08:30', 1, 'AYPR');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Ma', '07:00', '08:30', 2, 'AYPR');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Vi', '07:00', '08:30', 2, 'AYPR');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Lu', '16:00', '17:30', 1, 'AYED');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Vi', '13:00', '14:30', 1, 'AYED');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Ma', '13:00', '14:30', 2, 'AYED');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Mi', '10:00', '11:30', 2, 'AYED');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Lu', '10:00', '11:30', 1, 'ACSO');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Ju', '10:00', '11:30', 1, 'ACSO');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Ma', '07:00', '10:00', 1, 'RECO');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Vi', '07:00', '10:00', 2, 'RECO');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Vi', '16:00', '19:00', 1, 'SPTI');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Lu', '13:00', '14:30', 1, 'AREP');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Mi', '16:00', '17:30', 1, 'AREP');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Lu', '16:00', '17:30', 2, 'AREP');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ('Ju', '16:00', '17:30', 2, 'AREP');
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();
insert into public.fecha (dia, hora_inicio, hora_fin, grupo_numero_id, grupo_materia_id) values ();







select * from public.fecha;
delete from public.fecha; 


























