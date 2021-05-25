package edu.eci.ecihorarios.model.bean;

import java.time.LocalTime;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Grupo {
	
	private int numero;
	private Map<String, Pair<LocalTime, LocalTime>> fechas;

}
