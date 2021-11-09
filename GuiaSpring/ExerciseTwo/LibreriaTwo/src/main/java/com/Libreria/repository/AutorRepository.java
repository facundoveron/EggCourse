package com.Libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Libreria.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String>{
	
	Autor findByNombre(String nombre);
}