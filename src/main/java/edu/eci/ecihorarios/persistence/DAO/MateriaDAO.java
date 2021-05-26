package edu.eci.ecihorarios.persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Materia;

public class MateriaDAO {

	public void agregar(Materia materia) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.materia (nombre, sigla, descripcion, creditos, area_id) values (?,?,?,?,?)")) {
			st.setString(1, materia.getNombre());
			st.setString(2, materia.getSigla());
			st.setString(3, materia.getDescripcion());
			st.setInt(4, materia.getCreditos());
			st.setInt(5, materia.getArea().getCodigo());
			st.executeUpdate();
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage());
		}
	}
	
	public void eliminar(Materia materia) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("delete from public.materia where sigla = ?")){
			st.setString(1, materia.getSigla());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public void agregarRequisitos(Materia materia, List<Materia> requisitos) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.requisito (materia_id, requisito_id) values (?,?)")) {
			for (Materia m: requisitos) {
				st.setString(1, materia.getSigla());
				st.setString(2, m.getSigla());
				st.addBatch();
			}
			st.executeBatch();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
	
	public Materia consultar(String sigla) throws PersistenceException {
		try (ResultSet rs = PersistenceManagerDAO.getConnection().createStatement().executeQuery(String.format("select * \n"
				+ "from public.materia as mat "
				+ "where mat.sigla = '%s'", sigla))){
			
			Materia mat = new Materia();
			if (rs.next()) {
				mat.setNombre(rs.getString("nombre"));
				mat.setSigla(sigla);
				mat.setDescripcion(rs.getString("descripcion"));
				mat.setCreditos(rs.getInt("creditos"));
				
				ResultSet rt = PersistenceManagerDAO.getConnection().createStatement().executeQuery(String.format("select mat.*\n"
						+ "from public.requisito as req join public.materia as mat on req.requisito_id = mat.sigla\n"
						+ "where req.materia_id = '%s'", sigla));
				
				List<Materia> requisitos = new ArrayList<Materia>();
				
				while (rt.next()) {
					Materia req = new Materia();
					req.setNombre(rs.getString("nombre"));
					req.setSigla(sigla);
					req.setDescripcion(rs.getString("descripcion"));
					req.setCreditos(rs.getInt("creditos"));
					
					requisitos.add(req);
				}
				
				mat.setRequisitos(requisitos);
				
				
			}
			
			return mat;
			
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage());
		}
	}
	
}
