package edu.eci.ecihorarios.backend;

import edu.eci.ecihorarios.exception.backend.PersistenceException;

public interface PersistenceManager {
	
	public static final String uri = "postgres://pqhssvszaprcti:c1417a8a0d6964fbfdf33697c225b2de113e9bf6272a7de6c8a2604c42771ffd@ec2-3-222-11-129.compute-1.amazonaws.com:5432/d3a9ac4u7urutl";  
	
	public boolean agregarMateria() throws PersistenceException;
	public boolean agregarPlan() throws PersistenceException;
	
	//login
	public boolean checkLogin(String usuario, String contraseña) throws PersistenceException;

}
