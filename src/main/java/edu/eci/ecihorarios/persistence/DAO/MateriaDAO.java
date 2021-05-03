package edu.eci.ecihorarios.persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Materia;

public class MateriaDAO {

	public void agregar(Materia materia) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.materia (profesor, nombre, sigla, descripcion, creditos, area_id) values (?,?,?,?,?,?)")) {
			st.setString(1, materia.getProfesor());
			st.setString(2, materia.getNombre());
			st.setString(3, materia.getSigla());
			st.setString(4, materia.getDescripcion());
			st.setInt(5, materia.getCreditos());
			st.setInt(6, materia.getArea().getCodigo());
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
	
}
