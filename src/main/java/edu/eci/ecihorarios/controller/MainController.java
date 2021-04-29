package edu.eci.ecihorarios.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class MainController {

//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public ResponseEntity<?> toMainPage(){
//		return null;
//	}
	
	@RequestMapping(value="/app/check-login", method=RequestMethod.POST)
	public ResponseEntity<?> checkLogin(@RequestBody JsonObject json) {
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	
}
