package com.hapVida.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hapVida.entities.Tutor;
import com.hapVida.services.TutorService;

@RestController
@RequestMapping(value = "/tutor")
@CrossOrigin(value = "http://localhost:4200")
//extends futuro controllerCustom
public class TutorController {
	
	@Autowired
	private TutorService Service;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Tutor> listaDeTutor(){
		return this.Service.listaDeTutor();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tutor salvarTutor(@Valid @RequestBody Tutor tutor) {
		return  this.Service.salvar(tutor);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<Tutor> atualizarTutor(@PathVariable Long id, @RequestBody Tutor tutor ){
		return this.Service.atualizarTutor(id, tutor);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Tutor> deletaTutor(@PathVariable Long id ){
		return this.Service.deletaTutor(id);
	}

}
