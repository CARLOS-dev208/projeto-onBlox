package com.sistemacontroler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemacontroler.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByCodigo(Long codigo);
	Cliente findByVendedorCodigo(Long codigo);
}
