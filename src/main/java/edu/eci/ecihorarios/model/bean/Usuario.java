package edu.eci.ecihorarios.model.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public abstract class Usuario {

	private String nombre;
	private String identificacion;
	private char tipo;
	private String correo;
	private String nombreUsuario;
	
}
