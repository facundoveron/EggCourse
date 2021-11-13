package com.Libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Libreria.entities.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, String>{

}
