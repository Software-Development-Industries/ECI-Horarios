package edu.eci.ecihorarios.persistence.DAO;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Estudiante;
import edu.eci.ecihorarios.model.bean.Inscripcion;
import edu.eci.ecihorarios.model.bean.Usuario;
import edu.eci.ecihorarios.persistence.PersistenceManager;
import edu.eci.ecihorarios.services.persistence.Connector;

@Component(value="DAO")
public class PersistenceManagerDAO implements PersistenceManager <Estudiante>{
	
	public synchronized static Connection getConnection() throws PersistenceException {
		return Connector.getInstance().getConnection();
	}
	
	private AdministradorDAO admin;
	private EstudianteDAO estudiante;
	private InscripcionDAO inscripcion;
	private HorarioDAO horario;
	private PlanEstudioDAO plan;
	private MateriaDAO materia;
	private GrupoDAO grupo;
	
	public PersistenceManagerDAO() {
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
	public Estudiante studentLogin(String user, String contraseña) throws PersistenceException {
		return estudiante.checkLogin(user, contraseña);
	}


	@Override
	public Estudiante getStudentByUsername(String username) throws PersistenceException {
		return estudiante.getByUsername(username);
	}


	@Override
	public List<Inscripcion> getStudentPlans(String username) throws PersistenceException {
		return inscripcion.getPlans(username);
	}


}
