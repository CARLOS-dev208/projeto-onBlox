package com.hapVida.repositories;

import com.hapVida.view.AnimalView;
import com.hapVida.view.TutorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hapVida.entities.Animal;

import javax.persistence.Tuple;

@Repository
//extend do RepositoryCustom
public interface AnimalRepository extends JpaRepository<Animal, Long>{
	Animal findByCodigo(Long codigo);
	Animal findByAnimalCodigo(Long codigo);

	@Override
	public AnimalView findViewCrudById(Long id) {
		return (AnimalView) super.getEntityManager().createNativeQuery(
				AnimalView.nativaQuery() +
						"AND animal.id = :id\n"
				, Tuple.class)
				.setParameter("id", id)
				.getResultList()
				.stream()
				.map(t -> new AnimalView((Tuple) t))
				.findFirst().orElse(null);
}
