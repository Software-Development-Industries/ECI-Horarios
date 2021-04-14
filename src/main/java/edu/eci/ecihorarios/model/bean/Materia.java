package edu.eci.ecihorarios.model.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Materia {

	private String profesor;
	private String nombre;
	private String sigla;
	private String descripcion;
	private int creditos;
	private Area area;
	private boolean aprobada;
	
	private List<Materia> requisitos;
	
}
