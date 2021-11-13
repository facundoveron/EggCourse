 package com.Libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Libreria.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	Cliente findByDocumento(Long documento);
	
	Cliente findByTelefono(String telefono);
}
