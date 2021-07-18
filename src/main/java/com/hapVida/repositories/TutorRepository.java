package com.hapVida.repositories;

import com.hapVida.view.TutorView;
import com.hapVida.view.VeterinarioView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hapVida.entities.Tutor;

import javax.persistence.Tuple;

@Repository
//extend do RepositoryCustom
public interface TutorRepository extends JpaRepository<Tutor, Long>{

	Tutor findByCodigo(Long id);

	@Override
	public TutorView findViewCrudById(Long id) {
		return (TutorView) super.getEntityManager().createNativeQuery(
				TutorView.nativaQuery() +
						"AND tutor.id = :id\n"
				, Tuple.class)
				.setParameter("id", id)
				.getResultList()
				.stream()
				.map(t -> new TutorView((Tuple) t))
				.findFirst().orElse(null);

	
}
