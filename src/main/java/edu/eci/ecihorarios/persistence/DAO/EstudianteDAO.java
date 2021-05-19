package edu.eci.ecihorarios.persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Area;
import edu.eci.ecihorarios.model.bean.Estudiante;
import edu.eci.ecihorarios.model.bean.Materia;
import edu.eci.ecihorarios.model.bean.PlanEstudio;
import edu.eci.ecihorarios.model.bean.Usuario;

public class EstudianteDAO extends UsuarioDAO <Estudiante>{

	
	public void agregar(Estudiante newStudent, String password) throws PersistenceException{
		agregar((Usuario)newStudent, password);
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.estudiante (id, tipo_id) values (?,?)")) {
			st.setInt(1, newStudent.getIdentificacion());
			st.setString(2, String.valueOf(newStudent.getTipo()));
			st.executeUpdate();
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage());
		}
	}
	
	public Estudiante consultar(int id, char tipoId) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("select us.* from public.usuario us join public.estudiante est "
				+ "on us.id = est.id where est.id = ? and est.tipo_id = ?")) {
			st.setInt(1, id);
			st.setString(2, String.valueOf(tipoId));
			
			ResultSet rs = st.executeQuery();
			Estudiante est = new Estudiante();
			while (rs.next()) {
				est.setNombre(rs.getString("nombre"));
				est.setEdad(rs.getInt("edad"));
				est.setIdentificacion(rs.getInt("id"));
				est.setTipo(rs.getString("tipo_id").charAt(0));
				est.setCorreo(rs.getString("correo"));
				est.setNombreUsuario(rs.getString("login"));
			}
			
			return est;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public Estudiante getByUsername(String username) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("select us.* from public.usuario us join public.estudiante est "
				+ "on us.id = est.id where us.login = ?")) {
			st.setString(1, username);
			
			ResultSet rs = st.executeQuery();
			Estudiante est = new Estudiante();
			while (rs.next()) {
				est.setNombre(rs.getString("nombre"));
				est.setEdad(rs.getInt("edad"));
				est.setIdentificacion(rs.getInt("id"));
				est.setTipo(rs.getString("tipo_id").charAt(0));
				est.setCorreo(rs.getString("correo"));
				est.setNombreUsuario(rs.getString("login"));
			}
			
			return est;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public Estudiante consultar(String correo) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("select us.* from public.usuario us join public.estudiante est "
				+ "on us.id = est.id where us.correo = ?")) {
			st.setString(1, correo);
			
			ResultSet rs = st.executeQuery();
			Estudiante est = new Estudiante();
			while (rs.next()) {
				est.setNombre(rs.getString("nombre"));
				est.setEdad(rs.getInt("edad"));
				est.setIdentificacion(rs.getInt("id"));
				est.setTipo(rs.getString("tipo_id").charAt(0));
				est.setCorreo(rs.getString("correo"));
				est.setNombreUsuario(rs.getString("login"));
			}
			
			return est;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public void eliminar(Estudiante estudiante) throws PersistenceException {
		eliminar((Usuario)estudiante);
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("delete from public.estudiante where id=? and tipo_id=?")){
			st.setInt(1, estudiante.getIdentificacion());
			st.setString(2, String.valueOf(estudiante.getTipo()));
			st.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	
	public void agregarPlan(Estudiante estudiante, PlanEstudio plan) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.plan_estudio_estudiante (estudiante_id, estudiante_tipo_id, plan_id) "
				+ "values (?,?,?)")) {
			st.setInt(1, estudiante.getIdentificacion());
			st.setString(2, String.valueOf(estudiante.getTipo()));
			st.setInt(3, plan.getId());
			st.executeUpdate();
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage());
		}
	}
	
	public void agregarPlan(Estudiante estudiante, List<PlanEstudio> planes) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.plan_estudio_estudiante (estudiante_id, estudiante_tipo_id, plan_id) "
				+ "values (?,?,?)")) {
			
			for (PlanEstudio plan: planes) {
				st.setInt(1, estudiante.getIdentificacion());
				st.setString(2, String.valueOf(estudiante.getTipo()));
				st.setInt(3, plan.getId());
				st.addBatch();
			}
			
			st.executeBatch();
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage());
		}
	}
	
	public void registrarMaterias(Estudiante estudiante, List<Materia> materias) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.registro_materias (estudiante_id, tipo_id_est, materia_id, superada)"
				+ "values (?,?,?,?)")) {
			for (Materia m: materias) {
				st.setInt(1, estudiante.getIdentificacion());
				st.setString(2, String.valueOf(estudiante.getTipo()));
				st.setString(3, m.getSigla());
				st.setBoolean(4, m.isAprobada());
				st.addBatch();
			}
			st.executeBatch();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public List<Materia> getRegistroMaterias(Estudiante estudiante) throws PersistenceException {
		List<Materia> materias = new ArrayList<Materia>();
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("select reg.superada, mat.*, ar.codigo, ar.nombre as \"nombre_area\" from public.estudiante est, public.registro_materias reg, public.materia mat, public.area_encargada ar\n"
				+ "where est.id = reg.estudiante_id and reg.materia_id = mat.sigla and mat.area_id = ar.codigo and est.id = ? and est.tipo_id = ?")) {
			st.setInt(1, estudiante.getIdentificacion());
			st.setString(2, String.valueOf(estudiante.getTipo()));
		
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				materias.add(new Materia(
						rs.getString("profesor"),
						rs.getString("nombre"),
						rs.getString("sigla"),
						rs.getString("descripcion"),
						rs.getInt("creditos"),
						new Area(rs.getInt("codigo"), rs.getString("nombre_area")),
						rs.getBoolean("superada"),
						null
					));
			}
			
			return materias;
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage()); 
		}
	}

	public Estudiante checkLogin(String usuario, String contraseña) throws PersistenceException {
		try (ResultSet rs = PersistenceManagerDAO.getConnection().createStatement().executeQuery(String.format("select us.* from public.usuario as us join public.login as lo on lo.nombre_usuario = us.login \n"
				+ "where lo.nombre_usuario='%s' and lo.contraseña='%s'", usuario, contraseña))) {
			Estudiante user = new Estudiante();
			if (rs.next()) {
				user.setNombre(rs.getString("nombre"));
				user.setEdad(rs.getInt("edad"));
				user.setIdentificacion(rs.getInt("id"));
				user.setTipo(rs.getString("tipo_id").charAt(0));
				user.setCorreo(rs.getString("correo"));
				user.setNombreUsuario(rs.getString("login"));
			} else {
				throw new PersistenceException("Usuario no encontrado");
			}

			return user;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		
	}

	
	
}
