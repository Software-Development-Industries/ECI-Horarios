package edu.eci.ecihorarios.persistence.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Usuario;

public class UsuarioDAO {
	
	
	public void agregar(Usuario newUser, String password) throws PersistenceException {
		Connection con = PersistenceManagerDAO.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement("insert into public.login (nombre_usuario, contraseña) values (?, ?)");
			st.setString(1, newUser.getNombreUsuario());
			st.setString(2, password);
			st.executeUpdate();
			
			st = con.prepareStatement("insert into public.usuario (nombre, edad, id, tipo_id, correo, login) values (?,?,?,?,?,?)");
			st.setString(1, newUser.getNombre());
			st.setInt(2, newUser.getEdad());
			st.setInt(3, newUser.getIdentificacion());
			st.setString(4, String.valueOf(newUser.getTipo()));
			st.setString(5, newUser.getCorreo());
			st.setString(6, newUser.getNombreUsuario());
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public void agregar(
			String nombre,
			int edad,
			int id,
			char tipoId,
			String correo,
			String username,
			String password) throws PersistenceException {
		
		this.agregar(
				new Usuario(nombre, edad, id, tipoId, correo, username),
				password);
		
	}
	
	public Usuario consultar(int id, char tipoId) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("select * from public.usuario where id = ? and tipo_id = ?")) {
			st.setInt(1, id);
			st.setString(2, String.valueOf(tipoId));
			
			ResultSet rs = st.executeQuery();
			Usuario user = new Usuario();
			while (rs.next()) {
				user.setNombre(rs.getString("nombre"));
				user.setEdad(rs.getInt("edad"));
				user.setIdentificacion(rs.getInt("id"));
				user.setTipo(rs.getString("tipo_id").charAt(0));
				user.setCorreo(rs.getString("correo"));
				user.setNombreUsuario(rs.getString("login"));
			}
			
			return user;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public Usuario consultar(String correo) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("select * from public.usuario where correo = ?")) {
			st.setString(1, correo);
			
			ResultSet rs = st.executeQuery();
			Usuario user = new Usuario();
			while (rs.next()) {
				user.setNombre(rs.getString("nombre"));
				user.setEdad(rs.getInt("edad"));
				user.setIdentificacion(rs.getInt("id"));
				user.setTipo(rs.getString("tipo_id").charAt(0));
				user.setCorreo(rs.getString("correo"));
				user.setNombreUsuario(rs.getString("login"));
			}
			
			return user;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public void eliminar(Usuario usuario) throws PersistenceException {
		try {
			
			PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("delete from public.usuario where id = ? and tipo_id = ?");
			st.setInt(1, usuario.getIdentificacion());
			st.setString(2, String.valueOf(usuario.getTipo()));
			if (st.executeUpdate() <= 0) throw new PersistenceException("No se pudo eliminar usuario "+usuario.getNombre()); 
			
			st = PersistenceManagerDAO.getConnection().prepareStatement("delete from public.login where nombre_usuario = ?");
			st.setString(1, usuario.getNombreUsuario());
			if (st.executeUpdate() <= 0) throw new PersistenceException("No se pudo eliminar usuario "+usuario.getNombre());
			
			st.close();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public boolean checkLogin(String usuario, String contraseña) throws PersistenceException {
		try (ResultSet rs = PersistenceManagerDAO.getConnection().createStatement().executeQuery(String.format("select * from public.login where nombre_usuario='%s' and contraseña='%s'", usuario, contraseña))) {
			return rs.next();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		
	}
	
	public void cambiarContraseña(String username, String newPassword) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("update public.login set contraseña = ? where nombre_usuario = ?")){
			st.setString(1, newPassword);
			st.setString(2, username);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}

}
