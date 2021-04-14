package edu.eci.ecihorarios.model.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class PlanEstudio {

	private int id;
	private int creditosTotales;
	private List<Materia> materias;
	
	
}
