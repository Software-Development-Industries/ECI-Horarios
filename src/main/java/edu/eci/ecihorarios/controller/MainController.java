package edu.eci.ecihorarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class MainController {

	
	@RequestMapping(value="/app/check-login", 
					method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<?> checkLogin(@RequestBody String req) {
		JsonObject json = JsonParser.parseString(req).getAsJsonObject();
		System.out.println(json);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
}
