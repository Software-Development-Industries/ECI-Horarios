package edu.eci.ecihorarios.services.backend;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import edu.eci.ecihorarios.backend.PersistenceManager;

public class LoadBalancer {
	
	private static LoadBalancer lb = new LoadBalancer();
	
	public static PersistenceManager getNextManager() {
		return lb.next();
	}
	
	
	private Queue<PersistenceManager> managers;
	
	private LoadBalancer() {
		managers = new ArrayBlockingQueue<PersistenceManager>(10);
	}
	
	private PersistenceManager next() {
		PersistenceManager result = managers.poll();
		managers.add(result);
		return result;
	}

}
