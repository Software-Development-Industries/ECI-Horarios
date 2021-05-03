package edu.eci.ecihorarios.persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Admin;
import edu.eci.ecihorarios.model.bean.Area;
import edu.eci.ecihorarios.model.bean.Usuario;

public class AdministradorDAO extends UsuarioDAO{

	public void agregar(Admin newAdmin, String password) throws PersistenceException {
		agregar((Usuario)newAdmin, password);
		
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.administrador (id, tipo_id, area_id) values (?, ?, ?)")){
			st.setInt(1, newAdmin.getIdentificacion());
			st.setString(2, String.valueOf(newAdmin.getTipo()));
			st.setInt(3, newAdmin.getArea().getCodigo());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public Admin consultar(int id, char tipoId) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("select us.*, ar.codigo, ar.nombre as \"area\" from public.usuario us, public.administrador ad, public.area_encargada ar "
				+ "where us.id = ad.id and ad.area_id = ar.codigo and ad.id = ? and ad.tipo_id = ?")) {
			st.setInt(1, id);
			st.setString(2, String.valueOf(tipoId));
			
			ResultSet rs = st.executeQuery();
			Admin admin = new Admin();
			while (rs.next()) {
				admin.setNombre(rs.getString("nombre"));
				admin.setEdad(rs.getInt("edad"));
				admin.setIdentificacion(rs.getInt("id"));
				admin.setTipo(rs.getString("tipo_id").charAt(0));
				admin.setCorreo(rs.getString("correo"));
				admin.setNombreUsuario(rs.getString("login"));
				admin.setArea(new Area(rs.getInt("codigo"), rs.getString("area")));
			}
			
			return admin;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public Admin consultar(String correo) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("select us.*, ar.codigo, ar.nombre as \"area\" from public.usuario us, public.administrador ad, public.area_encargada ar "
				+ "where us.id = ad.id and ad.area_id = ar.codigo and us.correo = ?")) {
			st.setString(1, correo);
			
			ResultSet rs = st.executeQuery();
			Admin admin = new Admin();
			while (rs.next()) {
				admin.setNombre(rs.getString("nombre"));
				admin.setEdad(rs.getInt("edad"));
				admin.setIdentificacion(rs.getInt("id"));
				admin.setTipo(rs.getString("tipo_id").charAt(0));
				admin.setCorreo(rs.getString("correo"));
				admin.setNombreUsuario(rs.getString("login"));
				admin.setArea(new Area(rs.getInt("codigo"), rs.getString("area")));
			}
			
			return admin;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	
	public void eliminar(Admin admin) throws PersistenceException{
		eliminar((Usuario)admin);
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("delete from public.administrador where id=? and tipo_id=?")){
			st.setInt(1, admin.getIdentificacion());
			st.setString(2, String.valueOf(admin.getTipo()));
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	
}
