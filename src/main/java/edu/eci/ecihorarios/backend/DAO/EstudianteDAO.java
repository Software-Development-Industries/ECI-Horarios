package edu.eci.ecihorarios.backend.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.eci.ecihorarios.exception.backend.PersistenceException;
import edu.eci.ecihorarios.model.bean.Estudiante;
import edu.eci.ecihorarios.model.bean.Usuario;

public class EstudianteDAO extends UsuarioDAO{

	
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
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	
}
