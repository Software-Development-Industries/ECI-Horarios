package edu.eci.ecihorarios;


import static org.junit.Assert.*;

import org.junit.Test;

import edu.eci.ecihorarios.exception.persistence.PersistenceException;
import edu.eci.ecihorarios.model.bean.Estudiante;
import edu.eci.ecihorarios.persistence.PersistenceManager;
import edu.eci.ecihorarios.persistence.DAO.PersistenceManagerDAO;

public class PersistenceTest {

	@Test
	public void verificarLogin() {
		PersistenceManager<Estudiante> persistenceMg = new PersistenceManagerDAO();
		try {
			assertEquals(persistenceMg.studentLogin("eduard.arias", "eduard_lol1234").getIdentificacion(), 1234);
		} catch (PersistenceException perEx) {
			fail(perEx.getMessage());
		}
	}

}
