package com.sistemacontroler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemacontroler.entities.Vendedor;
import com.sistemacontroler.exception.NegocioException;
import com.sistemacontroler.repositories.VendedorRepository;

@Service
public class VendedorService {

	
	@Autowired
	private VendedorRepository vendedorRepository;

	public Vendedor salvar(Vendedor vendedor) {
		
	Vendedor vendedorCodigo = this.vendedorRepository.findByCodigo(vendedor.getCodigo());
		
		if(vendedorCodigo != null && !vendedorCodigo.equals(vendedor.getCodigo())) {
			throw new NegocioException("Já existe um vendedor cadastro com esse Código");
		}
		
		return this.vendedorRepository.save(vendedor);
	}

	public ResponseEntity<Vendedor> atualizarVendedor(Long id, Vendedor vendedor) {
		if(!this.vendedorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		vendedor.setId(id);
		vendedor = this.vendedorRepository.save(vendedor);
		return ResponseEntity.ok(vendedor);
	
	}

	public ResponseEntity<Vendedor> deletaVendedor(Long id) {
		if(!this.vendedorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		this.vendedorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public List<Vendedor> listaDeVendedor() {	
		return this.vendedorRepository.findAll();
	}
}
