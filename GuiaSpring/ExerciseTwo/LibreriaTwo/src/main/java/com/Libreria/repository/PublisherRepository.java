package com.Libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Libreria.entities.Editorial;

@Repository
public interface PublisherRepository extends JpaRepository<Editorial, String>{

}
