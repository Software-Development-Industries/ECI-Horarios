package edu.eci.ecihorarios.backend.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.eci.ecihorarios.backend.PersistenceManager;
import edu.eci.ecihorarios.exception.backend.PersistenceException;

public class PersistenceManagerDAO implements PersistenceManager {
	
	private static Connection con = null;
	
	private static final String uri = "postgres://pqhssvszaprcti:c1417a8a0d6964fbfdf33697c225b2de113e9bf6272a7de6c8a2604c42771ffd@ec2-3-222-11-129.compute-1.amazonaws.com:5432/d3a9ac4u7urutl";
	
	public synchronized static Connection getConnection() throws PersistenceException {
		if (con == null) {
			try {
				con = DriverManager.getConnection(PersistenceManagerDAO.uri);
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
		return con;
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
