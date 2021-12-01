package com.Estancia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estancia.Entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	Usuario findByEmail(String email);
}
