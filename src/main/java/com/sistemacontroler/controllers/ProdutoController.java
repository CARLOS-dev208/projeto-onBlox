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

import com.sistemacontroler.entities.Produto;
import com.sistemacontroler.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin(value = "http://localhost:4200")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listaDeProduto(){
		return this.produtoService.listaDeProduto();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto salvarProduto(@Valid @RequestBody Produto produto) {
		return  this.produtoService.salvar(produto);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto ){
		return this.produtoService.atualizarProduto(id, produto);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deletaProdutor(@PathVariable Long id ){
		return this.produtoService.deletaProduto(id);
	}

}
