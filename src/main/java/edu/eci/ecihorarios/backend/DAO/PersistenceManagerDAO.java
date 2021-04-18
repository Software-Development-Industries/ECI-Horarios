package edu.eci.ecihorarios.backend.DAO;

import java.sql.Connection;

import edu.eci.ecihorarios.backend.PersistenceManager;
import edu.eci.ecihorarios.exception.backend.PersistenceException;
import edu.eci.ecihorarios.services.backend.Connector;

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
	public boolean checkLogin(String user, String contraseña) throws PersistenceException {
		return usuario.checkLogin(user, contraseña);
	}

}
