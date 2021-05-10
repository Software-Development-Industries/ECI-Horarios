package edu.eci.ecihorarios.model.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class MateriaController {
	
	@RequestMapping(value="/users/{user}/plan-estudio", method=RequestMethod.GET)
	public ResponseEntity<?> getPlanEstudio(@PathVariable("user") String user){
		return null;
	}

}
