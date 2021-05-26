package edu.eci.ecihorarios.services.server.worker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import edu.eci.ecihorarios.exception.app.AppException;
import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Estudiante;
import edu.eci.ecihorarios.model.bean.Inscripcion;
import edu.eci.ecihorarios.model.bean.Materia;
import edu.eci.ecihorarios.model.bean.Usuario;
import edu.eci.ecihorarios.services.persistence.LoadBalancer;
import edu.eci.ecihorarios.services.security.SecurityServices;
import edu.eci.ecihorarios.services.security.impl.SecurityWorker;

@Service
public class ServiceWorker {
	
	@Autowired
	@Qualifier("security-worker")
	private SecurityServices security;
	
	public ServiceWorker() {
		security = new SecurityWorker();
	}

	public boolean studentLogin(String username, String pass) throws AppException {
		try {
			Estudiante user = (Estudiante) LoadBalancer.getNextManager().studentLogin(username, security.hashData(pass));
			return user.getNombreUsuario().equals(username);
		} catch (PersistenceException e) {
			throw new AppException(e.getMessage());
		}
	}
	
	public Estudiante getStudentByUsername(String username) throws AppException {
		try {
			return (Estudiante) LoadBalancer.getNextManager().getStudentByUsername(username);
		} catch (PersistenceException perEx) {
			throw new AppException("No se ha encontrado el usuario");
		}
	}
	
	public List<Inscripcion> getStudentPlans(String username) throws AppException {
		try {
			return LoadBalancer.getNextManager().getStudentPlans(username);
		} catch (PersistenceException perEx) {
			throw new AppException("Error en la peticion: "+ perEx.getMessage());
		}
	}
	
	public Materia getInfoMateria(String sigla) throws AppException {
		try {
			return LoadBalancer.getNextManager().getInfoMateria(sigla);
		} catch (PersistenceException perEx) {
			throw new AppException("La materia solicitada no existe");
		}
	}
	
	public void preinscribir(JsonObject inscripcion) throws AppException {
		try {
			LoadBalancer.getNextManager().preinscribir(inscripcion);
		} catch (PersistenceException perEx) {
			throw new AppException("No se pudo realizar la inscripción -> "+perEx.getMessage());
		}
	}
	
}
