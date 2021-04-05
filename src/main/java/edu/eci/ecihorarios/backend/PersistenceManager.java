package edu.eci.ecihorarios.backend;

import edu.eci.ecihorarios.exception.backend.PersistenceException;

public interface PersistenceManager {
	
	public boolean agregarMateria() throws PersistenceException;
	public boolean agregarPlan() throws PersistenceException;

}
