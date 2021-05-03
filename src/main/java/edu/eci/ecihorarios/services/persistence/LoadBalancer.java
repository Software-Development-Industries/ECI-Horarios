package edu.eci.ecihorarios.services.persistence;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import edu.eci.ecihorarios.persistence.PersistenceManager;

public class LoadBalancer {
	
	private static LoadBalancer lb = new LoadBalancer();
	private static final int MANAGERS_POOL = 10;
	
	public static PersistenceManager getNextManager() {
		return lb.next();
	}
	
	public static int getManagersAmount() {
		return MANAGERS_POOL;
	}
	
	
	private Queue<PersistenceManager> managers;
	
	private LoadBalancer() {
		managers = new ArrayBlockingQueue<PersistenceManager>(MANAGERS_POOL);
	}
	
	private PersistenceManager next() {
		PersistenceManager result = managers.poll();
		managers.add(result);
		return result;
	}

}
