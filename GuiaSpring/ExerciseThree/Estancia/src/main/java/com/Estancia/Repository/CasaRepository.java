package com.Estancia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estancia.Entities.Casa;

@Repository
public interface CasaRepository extends JpaRepository<Casa, String>{
	
}
