package com.Estancia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estancia.Entities.Familia;
import com.Estancia.Entities.Usuario;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, String>{
	Familia findByUsuario(Usuario usuario);
}
