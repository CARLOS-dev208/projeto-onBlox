package com.sistemacontroler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemacontroler.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findByCodigo(Long codigo);

	
}
