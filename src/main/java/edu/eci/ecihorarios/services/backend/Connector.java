package edu.eci.ecihorarios.services.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.eci.ecihorarios.exception.backend.PersistenceException;

public class Connector {
	
	private static final int CONNECTIONS = LoadBalancer.getManagersAmount();
	private static final String uri = "postgres://pqhssvszaprcti:c1417a8a0d6964fbfdf33697c225b2de113e9bf6272a7de6c8a2604c42771ffd@ec2-3-222-11-129.compute-1.amazonaws.com:5432/d3a9ac4u7urutl";
	private static Connector _instance = null;
	
	
	public static Connector getInstance() throws PersistenceException {
		if (_instance == null) _instance = new Connector();
		return _instance;
	}
	
	private List<Connection> connections;
	private int currentConnection;
	
	public Connection getConnection() {
		return getNextConnection();
	}
	
	
	private Connector() throws PersistenceException{
		connections = new ArrayList<Connection>(CONNECTIONS);
		prepareConnections();
	}
	
	private void prepareConnections() throws PersistenceException{
		for (int i=0; i<CONNECTIONS; i++) {
			try {
				connections.add(DriverManager.getConnection(uri));
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		currentConnection = 0;
	}
	
	private Connection getNextConnection() {
		Connection con = connections.get(currentConnection++);
		currentConnection %= connections.size(); 
		return con;
		
	}
	

}
