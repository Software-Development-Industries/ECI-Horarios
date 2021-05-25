package edu.eci.ecihorarios.persistence;

import java.util.List;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Inscripcion;

public interface PersistenceManager <T>{
	
	public boolean agregarMateria() throws PersistenceException;
	public boolean agregarPlan() throws PersistenceException;
	
	//login
	public T studentLogin(String usuario, String contraseña) throws PersistenceException;
	public T getStudentByUsername(String username) throws PersistenceException;
	
	public List<Inscripcion> getStudentPlans(String username) throws PersistenceException;

}
