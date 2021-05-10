package edu.eci.ecihorarios.services.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.eci.ecihorarios.services.persistence.LoadBalancer;
import edu.eci.ecihorarios.services.server.worker.ServiceWorker;

public class ServiceManager {

	private static ServiceManager serv = new ServiceManager();
	
	public synchronized static ServiceWorker getNextWorker() {
		return serv.next();
	}
	
	
	private List<ServiceWorker> workers;
	private Random selector;
	
	private ServiceManager() {
		workers = Collections.synchronizedList(new ArrayList<ServiceWorker>());
		for (int i=0; i<LoadBalancer.getManagersAmount(); i++) {
			workers.add(new ServiceWorker());
		}
		
	}
	
	private ServiceWorker next() {
		return workers.get(selector.nextInt(workers.size()));
	}
	
	
	
}
