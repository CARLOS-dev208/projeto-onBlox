package com.hapVida.controllers;

import java.util.List;

import javax.validation.Valid;

import com.hapVida.services.AnimalService;
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

import com.hapVida.dto.AnimalNewDTO;
import com.hapVida.entities.Animal;

@RestController
@RequestMapping(value = "/animal")
@CrossOrigin(value = "http://localhost:4200")
//extends futuro controllerCustom
public class AnimalController{
	
	@Autowired
	private AnimalService service;
	
	@GetMapping
	public List<Animal> listaDeAnimal(){
		return service.listaDeAnimal();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Animal salvarAnimal(@Valid @RequestBody AnimalNewDTO animal) {
		return  this.service.salvar(animal);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Animal> atualizarAnimal(@PathVariable Long id, @RequestBody Animal animal){
		return this.service.atualizarAnimal(id, animal);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletaAnimal(@PathVariable Long id){
		return this.service.deletaAnimal(id);
	}

}
