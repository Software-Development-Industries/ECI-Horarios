package edu.eci.ecihorarios.services.persistence;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.ecihorarios.persistence.PersistenceManager;
import edu.eci.ecihorarios.persistence.DAO.PersistenceManagerDAO;

@Service
public class LoadBalancer {
	
	private static LoadBalancer lb = null;
	private static final int MANAGERS_POOL = 10;
	
	public static PersistenceManager getNextManager() {
		if (lb == null) {
			lb = new LoadBalancer();
		}
		return lb.next();
	}
	
	public static int getManagersAmount() {
		return MANAGERS_POOL;
	}
	
	
	private Queue<PersistenceManager> managers;
	
	@Autowired
	@Qualifier("DAO")
	private PersistenceManager reference;
	
	private LoadBalancer() {
		reference = new PersistenceManagerDAO();
		init();
	}
	
	@PostConstruct
	private void init() {
		managers = new ArrayBlockingQueue<PersistenceManager>(MANAGERS_POOL);
		for (int i=0; i<getManagersAmount(); i++) {
			try {
				managers.add((PersistenceManager) Class.forName(reference.getClass().getName()).getConstructor().newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	private PersistenceManager next() {
		PersistenceManager result = managers.poll();
		managers.add(result);
		return result;
	}

}
