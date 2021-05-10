package edu.eci.ecihorarios.model.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.eci.ecihorarios.exception.app.AppException;
import edu.eci.ecihorarios.services.server.ServiceManager;

@RestController
public class MainController {

	
	@RequestMapping(value="/app/check-login", 
					method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<?> checkLogin(@RequestBody String req) {
		JsonObject json = JsonParser.parseString(req).getAsJsonObject();
		System.out.println(json);
		System.out.println(Thread.currentThread().getId());
		try {
			return new ResponseEntity<>(ServiceManager.getNextWorker().checkLogin(json.get("email").getAsString(), json.get("pass").getAsString()), HttpStatus.OK);
		} catch (AppException appEx) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
