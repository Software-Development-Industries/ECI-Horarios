package edu.eci.ecihorarios.persistence.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.eci.ecihorarios.model.bean.PlanEstudio;
import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Materia;

public class PlanEstudioDAO {
	
	public void agregar(PlanEstudio newPlan) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.plan_estudio (plan_id, creditos_totales) values (?,?)")) {
			st.setInt(1, newPlan.getId());
			st.setInt(2, newPlan.getCreditosTotales());
			st.executeUpdate();
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage());
		}
	}

	public void agregarMaterias(PlanEstudio plan, List<Materia> materias) throws PersistenceException {
		try (PreparedStatement st = PersistenceManagerDAO.getConnection().prepareStatement("insert into public.plan_materia (plan_id, materia_id) values (?,?)")) {
			for (Materia m: materias) {
				st.setInt(1, plan.getId());
				st.setString(2, m.getSigla());
				st.addBatch();
			}
			st.executeBatch();
		} catch (SQLException sqlEx) {
			throw new PersistenceException(sqlEx.getMessage());
		}
	}
	
	
}
