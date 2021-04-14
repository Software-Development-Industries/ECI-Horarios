package edu.eci.ecihorarios.model.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Admin extends Usuario {
	
	private Area area;
	
	public Admin(String nombre, int edad, int identificacion, char tipo, String correo, String nombreUsuario, Area area) {
		super(nombre, edad, identificacion, tipo, correo, nombreUsuario);
		this.area = area;
	}
	
}
