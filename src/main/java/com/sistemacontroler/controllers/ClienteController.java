package com.sistemacontroler.controllers;

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

import com.sistemacontroler.dto.ClienteNewDTO;
import com.sistemacontroler.entities.Cliente;
import com.sistemacontroler.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin(value = "http://localhost:4200")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<Cliente> listaDeClientes(){
		return service.listaDeCliente();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvarCliente(@Valid @RequestBody ClienteNewDTO cliente) {
		return  this.service.salvar(cliente);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
		return this.service.atualizarCliente(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletaCliente(@PathVariable Long id){
		return this.service.deletaCliente(id);
	}

}
