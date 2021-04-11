create table Login (
	nombre_usuario varchar,
	contraseña varchar,
	ultimo_ingreso timestamp,
	
	primary key (nombre_usuario)
	
);

create table Usuario (
	nombre varchar,
	edad int,
	id int,
	tipo_id char,
	correo varchar not null,
	login varchar,
	
	primary key (id, tipo_id),
	foreign key (login) references Login (nombre_usuario)
);

create table Area_Encargada (
	codigo int,
	nombre varchar,
	
	primary key (codigo)
);

create table Estudiante (
	id int,
	tipo_id char,
	
	primary key (id, tipo_id),
	foreign key (id, tipo_id) references Usuario (id, tipo_id)
);

create table Inscripcion (
	MAX_CREDITOS int,
	id int,
	tipo char,
	fecha_inicio date,
	fecha_final date,
	estudiante_id int,
	estudiante_tipo_id char,
	
	primary key (id),
	foreign key (estudiante_id, estudiante_tipo_id) references Estudiante (id, tipo_id)
);

create table Preinscripcion (
	id int,
	estudiante_id int,
	estudiante_tipo_id char,
	
	primary key (id),
	foreign key (id) references Inscripcion (id),
	foreign key (estudiante_id, estudiante_tipo_id) references Estudiante (id, tipo_id)
);

create table Administrador (
	id int,
	tipo_id char,
	area_id int not null,
	
	primary key (id, tipo_id),
	foreign key (id, tipo_id) references Usuario (id, tipo_id),
	foreign key (area_id) references Area_Encargada (codigo)
	
);

create table Materia (
	profesor varchar,
	nombre varchar,
	sigla char(4),
	descripcion varchar,
	creditos int,
	area_id int not null,
	
	primary key (sigla),
	foreign key (area_id) references Area_Encargada (codigo)
);

create table Requisito (
	materia_id char(4),
	requisito_id char(4),
	
	primary key (materia_id, requisito_id),
	foreign key (materia_id) references Materia (sigla),
	foreign key (requisito_id) references Materia (sigla)
);

create table Grupo (
	cupo int,
	numero_id int,
	materia_id char(4) not null,
	
	primary key (numero_id, materia_id),
	foreign key (materia_id) references Materia (sigla)
);

create table Fecha (
	dia char(1),
	hora time,
	grupo_numero_id int,
	grupo_materia_id char(4),
	
	primary key (dia, grupo_numero_id, grupo_materia_id),
	foreign key (grupo_numero_id, grupo_materia_id) references Grupo (numero_id, materia_id)
);

create table Inscritos (
	estudiante_id int,
	estudiante_tipo_id char,
	grupo_numero_id int,
	grupo_materia_id char(4),
	
	primary key (estudiante_id, estudiante_tipo_id, grupo_numero_id, grupo_materia_id),
	foreign key (estudiante_id, estudiante_tipo_id) references Estudiante (id, tipo_id),
	foreign key (grupo_numero_id, grupo_materia_id) references Grupo (numero_id, materia_id)
);

create table Plan_Estudio (
	id int,
	creditos_totales int,
	
	primary key (id)
);

create table Plan_Estudio_Estudiante (
	estudiante_id int,
	estudiante_tipo_id char,
	plan_id int not null,
	
	primary key (estudiante_id, estudiante_tipo_id, plan_id),
	foreign key (estudiante_id, estudiante_tipo_id) references Estudiante (id, tipo_id)
);

create table Registro_Materias (
	plan_id int,
	materia_id char(4),
	superada bool

	primary key (plan_id, materia_id),
	foreign key (plan_id) references Plan_Estudio (id),
	foreign key (materia_id) references Materia (sigla)
);

create table Horario (
	numero_horario int,
	semestre int,
	tipo char,
	creditos int,
	inscripcion_id int not null,
	
	primary key (numero_horario, inscripcion_id),
	foreign key (inscripcion_id) references Inscipcion (id)
);

create table Horario_Materia (
	materia_id char(4) not null,
	horario_numero_id int,
	horario_inscripcion_id int,
	
	primary key (materia_id, horario_numero_id, horario_inscripcion_id),
	foreign key (materia_id) references Materia (sigla),
	foreign key (horario_numero_id, horario_inscripcion_id) references Horario (numero_horario, inscripcion_id)
);







