package edu.eci.ecihorarios.services.persistence;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.ecihorarios.persistence.PersistenceManager;

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
	private PersistenceManager reference;
	
	private LoadBalancer() {
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
