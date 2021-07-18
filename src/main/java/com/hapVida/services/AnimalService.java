package com.hapVida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hapVida.dto.AnimalNewDTO;
import com.hapVida.entities.Animal;
import com.hapVida.entities.Veterinario;
import com.hapVida.exception.NegocioException;
import com.hapVida.repositories.AnimalRepository;
import com.hapVida.repositories.VeterinarioRepository;

@Service
//futuro extends ServiceCustom
//criaria o validate para as validações
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private VeterinarioRepository veterinarioRepository;

	public Animal salvar(AnimalNewDTO animalNewDTO){
		Animal animal = this.animalRepository.findByCodigo(animalNewDTO.getCodigo());
		Veterinario veterinario = this.veterinarioRepository.findByCodigo(animalNewDTO.getCodigo());
		
		if(animal != null && !animal.equals(animalNewDTO.getCodigo())) {
			throw new NegocioException("Já existe um animal cadastro com esse Código");
		}
		
	
		if(veterinario == null ) {
			throw new NegocioException("Código de veterinario não existe");
		}
		
		Animal animal1 = new Animal(null, animalNewDTO.getCodigo(), animalNewDTO.getNome(),veterinario);
		
	return	this.animalRepository.save(animal);
		
	}


	public List<Animal> listaDeAnimal() {
		return this.animalRepository.findAll();
	}


	public ResponseEntity<Animal> atualizarAnimal(Long id, Animal animal) {
		if(!this.animalRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		animal.setId(id);
		animal = this.animalRepository.save(animal);
		return ResponseEntity.ok(animal);
	}


	public ResponseEntity<Void> deletaAnimal(Long id) {
		
		if(!this.animalRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		this.animalRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
