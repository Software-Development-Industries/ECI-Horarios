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
	fecha_inicio timestamp,
	fecha_final timestamp,
	estudiante_id int,
	estudiante_tipo_id char,
	
	primary key (id, estudiante_id),
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
	profesor varchar,
	
	primary key (numero_id, materia_id),
	foreign key (materia_id) references Materia (sigla)
);

create table Fecha (
	dia char(2),
	hora_inicio time,
	hora_fin time,
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
	estudiante_id int,
	tipo_id_est char,
	materia_id char(4),
	superada bool,

	primary key (estudiante_id, tipo_id_est, materia_id),
	foreign key (estudiante_id, tipo_id_est) references Estudiante (id, tipo_id),
	foreign key (materia_id) references Materia (sigla)
);

create table Plan_Materia (
	plan_id int,
	materia_id char(4),

	primary key (plan_id, materia_id),
	foreign key (plan_id) references Plan_Estudio (id),
	foreign key (materia_id) references Materia (sigla)
);

create table Horario (
	semestre int,
	tipo char,
	creditos int,
	inscripcion_id int not null,
	estudiante_id int not null,
	
	primary key (inscripcion_id, estudiante_id),
	foreign key (inscripcion_id, estudiante_id) references Inscripcion (id, estudiante_id)
);

create table Horario_Materia (
	materia_id char(4) not null,
	horario_inscripcion_id int,
	horario_estudiante_id int,
	
	primary key (materia_id, horario_inscripcion_id, horario_estudiante_id),
	foreign key (materia_id) references Materia (sigla),
	foreign key (horario_inscripcion_id, horario_estudiante_id) references Horario (inscripcion_id, estudiante_id)
);







