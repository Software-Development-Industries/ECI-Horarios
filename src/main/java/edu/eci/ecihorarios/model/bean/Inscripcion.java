package edu.eci.ecihorarios.model.bean;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Inscripcion {

	private char tipo;
	private int MAX_CREDITOS;
	
	private Horario horario;
	
}
