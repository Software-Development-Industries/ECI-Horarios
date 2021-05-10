package edu.eci.ecihorarios.persistence;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Usuario;

public interface PersistenceManager {
	
	public boolean agregarMateria() throws PersistenceException;
	public boolean agregarPlan() throws PersistenceException;
	
	//login
	public Usuario login(String usuario, String contraseña) throws PersistenceException;

}
