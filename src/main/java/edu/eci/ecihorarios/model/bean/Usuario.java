package edu.eci.ecihorarios.model.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Usuario {

	private String nombre;
	private int edad;
	private int identificacion;
	private char tipo;
	private String correo;
	private String nombreUsuario;
	
}
