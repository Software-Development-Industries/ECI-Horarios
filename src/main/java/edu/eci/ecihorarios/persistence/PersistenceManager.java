package edu.eci.ecihorarios.persistence;

import java.util.List;

import com.google.gson.JsonObject;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Inscripcion;
import edu.eci.ecihorarios.model.bean.Materia;

public interface PersistenceManager <T>{
	
	public boolean agregarMateria() throws PersistenceException;
	public boolean agregarPlan() throws PersistenceException;
	
	//login
	public T studentLogin(String usuario, String contraseña) throws PersistenceException;
	public T getStudentByUsername(String username) throws PersistenceException;
	
	public List<Inscripcion> getStudentPlans(String username) throws PersistenceException;
	
	public Materia getInfoMateria(String sigla) throws PersistenceException;
	
	public void preinscribir(JsonObject inscripcion) throws PersistenceException;

}
