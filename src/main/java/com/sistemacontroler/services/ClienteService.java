package com.sistemacontroler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemacontroler.dto.ClienteNewDTO;
import com.sistemacontroler.entities.Cliente;
import com.sistemacontroler.entities.Vendedor;
import com.sistemacontroler.exception.NegocioException;
import com.sistemacontroler.repositories.ClienteRepository;
import com.sistemacontroler.repositories.VendedorRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;


	public Cliente salvar(ClienteNewDTO clienteDto){
		Cliente clienteCodigo = this.clienteRepository.findByCodigo(clienteDto.getCodigo());
		Vendedor vendedor = this.vendedorRepository.findByCodigo(clienteDto.getVendedorCodigo());
		
		if(clienteCodigo != null && !clienteCodigo.equals(clienteDto.getCodigo())) {
			throw new NegocioException("Já existe um cliente cadastro com esse Código");
		}
		
	
		if(vendedor == null ) {
			throw new NegocioException("Código de vendedor não existe");
		}
		
		Cliente cliente = new Cliente(null, clienteDto.getCodigo(), clienteDto.getNome(),vendedor);
		
	return	this.clienteRepository.save(cliente);	
		
	}


	public List<Cliente> listaDeCliente() {
		return this.clienteRepository.findAll();
	}


	public ResponseEntity<Cliente> atualizarCliente(Long id, Cliente cliente) {
		if(!this.clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		cliente = this.clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}


	public ResponseEntity<Void> deletaCliente(Long id) {
		
		if(!this.clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		this.clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
