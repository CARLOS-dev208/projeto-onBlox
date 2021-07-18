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

import com.hapVida.entities.Veterinario;
import com.hapVida.services.VeterinarioService;

@RestController
@RequestMapping(value = "/veterinario")
@CrossOrigin(value = "http://localhost:4200")
//extends futuro controllerCustom
public class VeterinarioController {

	@Autowired
	private VeterinarioService service;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Veterinario> listaDeVeterinario(){
		return this.service.listaDeVeterinario();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veterinario salvarVeterinario(@Valid @RequestBody Veterinario veterinario) {
		return  this.service.salvar(veterinario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Veterinario> atualizarVeterinario(@PathVariable Long id, @RequestBody Veterinario veterinario ){
		return this.service.atualizarVeterinario(id, veterinario);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Veterinario> deletaVeterinario(@PathVariable Long id ){
		return this.service.deletaVeterinario(id);
	}
}
