package com.Estancia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Estancia.Entities.Cliente;
import com.Estancia.Entities.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	Cliente findByUsuario(Usuario usuario);
}
