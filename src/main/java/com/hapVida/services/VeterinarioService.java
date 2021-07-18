package com.hapVida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hapVida.entities.Veterinario;
import com.hapVida.exception.NegocioException;
import com.hapVida.repositories.VeterinarioRepository;

@Service
//criaria o validate para as validações
public class VeterinarioService {

	
	@Autowired
	private VeterinarioRepository veterinarioRepository;

	public Veterinario salvar(Veterinario vendedor) {
		
	Veterinario veterinario = this.veterinarioRepository.findByCodigo(vendedor.getId());
		
		if(veterinario != null && !veterinario.equals(vendedor.getId())) {
			throw new NegocioException("Já existe um veterinario cadastro com esse Código");
		}
		
		return this.veterinarioRepository.save(vendedor);
	}

	public ResponseEntity<Veterinario> atualizarVeterinario(Long id, Veterinario veterinario) {
		if(!this.veterinarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		veterinario.setId(id);
		veterinario = this.veterinarioRepository.save(veterinario);
		return ResponseEntity.ok(veterinario);
	
	}

	public ResponseEntity<Veterinario> deletaVeterinario(Long id) {
		if(!this.veterinarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		this.veterinarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public List<Veterinario> listaDeVeterinario() {
		return this.veterinarioRepository.findAll();
	}
}
