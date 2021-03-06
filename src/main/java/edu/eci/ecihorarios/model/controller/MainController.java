package edu.eci.ecihorarios.model.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.eci.ecihorarios.exception.app.AppException;
import edu.eci.ecihorarios.services.server.ServiceManager;

@RestController
@RequestMapping("/")
public class MainController {

	
	@RequestMapping(value="/app/user/login", 
					method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<?> checkLogin(@RequestBody String req) {
		JsonObject json = JsonParser.parseString(req).getAsJsonObject();
		try {
			return new ResponseEntity<>(ServiceManager.getNextWorker().studentLogin(json.get("email").getAsString(), json.get("pass").getAsString()), HttpStatus.OK);
		} catch (AppException appEx) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value="/app/user/{username}/data",
					method=RequestMethod.GET)
	public ResponseEntity<?> getStudentByUsername(@PathVariable String username) {
		try {
			return new ResponseEntity<>(ServiceManager.getNextWorker().getStudentByUsername(username) , HttpStatus.OK);
		} catch (AppException appEx) {
			return new ResponseEntity<>("No existe el usuario", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
