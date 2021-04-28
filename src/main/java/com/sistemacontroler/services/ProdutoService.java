package com.sistemacontroler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemacontroler.entities.Produto;
import com.sistemacontroler.exception.NegocioException;
import com.sistemacontroler.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto salvar(Produto produto) {
		
		Produto produtoCodigo = this.produtoRepository.findByCodigo(produto.getCodigo());
		
		if(produtoCodigo != null && !produtoCodigo.equals(produto.getCodigo())) {
			throw new NegocioException("Já existe um produto cadastro com esse Código");
		}
		
		return this.produtoRepository.save(produto);
	}

	public ResponseEntity<Produto> atualizarProduto(Long id, Produto produto) {
		if(!this.produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = this.produtoRepository.save(produto);
		return ResponseEntity.ok(produto);
	}

	public ResponseEntity<Produto> deletaProduto(Long id) {
		if(!this.produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		this.produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public List<Produto> listaDeProduto() {
		
		return this.produtoRepository.findAll();
	}
	


}
