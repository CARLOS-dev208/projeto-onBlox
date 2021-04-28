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

import com.sistemacontroler.entities.Vendedor;
import com.sistemacontroler.services.VendedorService;

@RestController
@RequestMapping(value = "/vendedores")
@CrossOrigin(value = "http://localhost:4200")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Vendedor> listaDeVendedor(){
		return this.vendedorService.listaDeVendedor();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vendedor salvarVendedor(@Valid @RequestBody Vendedor vendedor) {
		return  this.vendedorService.salvar(vendedor);
	}
	
	

	@PutMapping("/{id}")
	public ResponseEntity<Vendedor> atualizarCliente(@PathVariable Long id, @RequestBody Vendedor vendedor ){
		return this.vendedorService.atualizarVendedor(id, vendedor);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Vendedor> deletaVendedor(@PathVariable Long id ){
		return this.vendedorService.deletaVendedor(id);
	}
}
