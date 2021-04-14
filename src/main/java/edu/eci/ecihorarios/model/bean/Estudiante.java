package edu.eci.ecihorarios.model.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class Estudiante extends Usuario {

	private List<PlanEstudio> planes;
	
	public Estudiante() {
		planes = new ArrayList<PlanEstudio>();
	}

	public Estudiante(String nombre, int edad, int identificacion, char tipo, String correo, String nombreUsuario) {
		super(nombre, edad, identificacion, tipo, correo, nombreUsuario);
		planes = new ArrayList<PlanEstudio>();
	}
	
}
