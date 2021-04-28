package com.sistemacontroler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemacontroler.entities.Vendedor;


@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
 Vendedor findByCodigo(Long codigo);
 
// Optional<Vendedor>
}
