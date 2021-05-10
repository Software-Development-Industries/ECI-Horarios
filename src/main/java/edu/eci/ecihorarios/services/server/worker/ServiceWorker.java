package edu.eci.ecihorarios.services.server.worker;

import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.ecihorarios.exception.app.AppException;
import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Usuario;
import edu.eci.ecihorarios.services.persistence.LoadBalancer;
import edu.eci.ecihorarios.services.security.SecurityServices;

public class ServiceWorker {
	
	@Autowired
	private SecurityServices security;

	public boolean checkLogin(String username, String pass) throws AppException {
		try {
			Usuario user = LoadBalancer.getNextManager().login(username, security.encryptData(pass));
			return user.getNombreUsuario().equals(username);
		} catch (PersistenceException e) {
			throw new AppException(e.getMessage());
		}
	}
	
}
