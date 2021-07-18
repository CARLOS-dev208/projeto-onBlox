package com.hapVida.repositories;

import com.hapVida.view.VeterinarioView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hapVida.entities.Veterinario;

import javax.persistence.Tuple;


@Repository
//extend do RepositoryCustom
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
 Veterinario findByCodigo(Long codigo);

 @Override
 public VeterinarioView findViewCrudById(Long id) {
  return (VeterinarioView) super.getEntityManager().createNativeQuery(
          VeterinarioView.nativaQuery() +
                  "AND veterinario.id = :id\n"
          , Tuple.class)
          .setParameter("id", id)
          .getResultList()
          .stream()
          .map(t -> new VeterinarioView((Tuple) t))
          .findFirst().orElse(null);

 }}
