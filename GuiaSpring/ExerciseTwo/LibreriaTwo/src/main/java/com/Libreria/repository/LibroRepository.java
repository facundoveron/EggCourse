package com.Libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Libreria.entities.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String>{
	
	Libro findByTitulo(String titulo);
	
	Libro findByIsbn(Long isbn);
}
