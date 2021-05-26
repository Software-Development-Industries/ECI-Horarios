package edu.eci.ecihorarios.model.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.eci.ecihorarios.exception.app.AppException;
import edu.eci.ecihorarios.services.server.ServiceManager;

@RestController
@RequestMapping("/app")
public class MateriaController {
	
	@RequestMapping(value="/user/{user}/preinscripciones", 
					method=RequestMethod.GET)
	public ResponseEntity<?> getPreinscripciones(@PathVariable("user") String estudiante){
		try {
			return new ResponseEntity<>(ServiceManager.getNextWorker().getStudentPlans(estudiante), HttpStatus.OK);
		} catch (AppException appEx) {
			return new ResponseEntity<>(appEx.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/materia/{materia}/info",
					method=RequestMethod.GET)
	public ResponseEntity<?> getInfoMateria(@PathVariable("materia") String sigla) {
		try {
			return new ResponseEntity<>(ServiceManager.getNextWorker().getInfoMateria(sigla), HttpStatus.OK);
		} catch (AppException appEx) {
			return new ResponseEntity<>(appEx.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/user/{user}/preinscribir",
					method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<?> preinscribir(@PathVariable("user") String user, @RequestBody String body) {
		JsonObject json = JsonParser.parseString(body).getAsJsonObject();
		try {
			ServiceManager.getNextWorker().preinscribir(json);
			return new ResponseEntity<>("OK", HttpStatus.ACCEPTED);
		} catch (AppException appEx) {
			return new ResponseEntity<>(appEx.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
