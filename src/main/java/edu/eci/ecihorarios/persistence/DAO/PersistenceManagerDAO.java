package edu.eci.ecihorarios.persistence.DAO;

import java.sql.Connection;

import org.springframework.stereotype.Component;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Usuario;
import edu.eci.ecihorarios.persistence.PersistenceManager;
import edu.eci.ecihorarios.services.persistence.Connector;

@Component
public class PersistenceManagerDAO implements PersistenceManager {
	
	public synchronized static Connection getConnection() throws PersistenceException {
		return Connector.getInstance().getConnection();
	}
	
	private UsuarioDAO usuario;
	private AdministradorDAO admin;
	private EstudianteDAO estudiante;
	private InscripcionDAO inscripcion;
	private HorarioDAO horario;
	private PlanEstudioDAO plan;
	private MateriaDAO materia;
	private GrupoDAO grupo;
	
	public PersistenceManagerDAO() {
		usuario = new UsuarioDAO();
		admin = new AdministradorDAO();
		estudiante = new EstudianteDAO();
		inscripcion = new InscripcionDAO();
		horario = new HorarioDAO();
		plan = new PlanEstudioDAO();
		materia = new MateriaDAO();
		grupo = new GrupoDAO();
	}
	

	@Override
	public boolean agregarMateria() throws PersistenceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregarPlan() throws PersistenceException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Usuario login(String user, String contraseña) throws PersistenceException {
		return usuario.checkLogin(user, contraseña);
	}

}
