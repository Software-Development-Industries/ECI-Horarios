package edu.eci.ecihorarios.persistence;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;

public interface PersistenceManager {
	
	public boolean agregarMateria() throws PersistenceException;
	public boolean agregarPlan() throws PersistenceException;
	
	//login
	public boolean checkLogin(String usuario, String contraseña) throws PersistenceException;

}
