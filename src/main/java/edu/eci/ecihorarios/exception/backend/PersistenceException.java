package edu.eci.ecihorarios.exception.backend;

@SuppressWarnings("serial")
public class PersistenceException extends Exception {
	
	public PersistenceException() {
		super();
	}
	
	public PersistenceException(String message) {
		super(message);
	}

}
