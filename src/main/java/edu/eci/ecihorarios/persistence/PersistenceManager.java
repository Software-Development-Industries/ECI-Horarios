package edu.eci.ecihorarios.persistence;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;

public interface PersistenceManager <T>{
	
	public boolean agregarMateria() throws PersistenceException;
	public boolean agregarPlan() throws PersistenceException;
	
	//login
	public T studentLogin(String usuario, String contraseña) throws PersistenceException;
	public T getStudentByUsername(String username) throws PersistenceException;

}
