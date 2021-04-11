package edu.eci.ecihorarios.backend.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.eci.ecihorarios.backend.PersistenceManager;
import edu.eci.ecihorarios.exception.backend.PersistenceException;

public class UsuarioDAO {
	
	public boolean checkLogin(String usuario, String contraseña) throws PersistenceException {
		try {
			Connection con = DriverManager.getConnection(PersistenceManager.uri);
			ResultSet rs = con.createStatement().executeQuery(String.format("select * from public.Login where nombre_usuario='%s' and contraseña='%s'", usuario, contraseña));
			return rs.next();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		
	}

}
