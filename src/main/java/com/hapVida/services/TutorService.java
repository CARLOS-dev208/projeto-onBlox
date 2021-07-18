package com.hapVida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hapVida.entities.Tutor;
import com.hapVida.exception.NegocioException;
import com.hapVida.repositories.TutorRepository;

@Service
//criaria o validate para as validações
public class TutorService {
	@Autowired
	private TutorRepository tutorRepository;

	public Tutor salvar(Tutor tutor) {
		
		Tutor tutor1 = this.tutorRepository.findByCodigo(tutor.getId());
		
		if(tutor1 != null && !tutor1.equals(tutor.getId())) {
			throw new NegocioException("Já existe um tutor cadastro com esse Código");
		}
		
		return this.tutorRepository.save(tutor);
	}

	public ResponseEntity<Tutor> atualizarTutor(Long id, Tutor tutor) {
		if(!this.tutorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		tutor.setId(id);
		tutor = this.tutorRepository.save(tutor);
		return ResponseEntity.ok(tutor);
	}

	public ResponseEntity<Tutor> deletaTutor(Long id) {
		if(!this.tutorRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		this.tutorRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	public List<Tutor> listaDeTutor() {
		
		return this.tutorRepository.findAll();
	}
	


}
