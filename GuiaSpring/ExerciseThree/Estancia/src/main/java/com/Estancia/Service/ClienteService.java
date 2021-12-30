package com.Estancia.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estancia.Entities.Cliente;
import com.Estancia.Entities.Usuario;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Transactional
	public void registrarCliente(Cliente cliente, Usuario usuario)throws ErrorServicio{
		try {
			if(cliente.getNombre().trim().isEmpty() || cliente.getNombre() == null) {
				throw new ErrorServicio("Nombre vacio");
			}
			if(cliente.getCalle().trim().isEmpty() || cliente.getCalle() == null) {
				throw new ErrorServicio("Calle vacio");
			}
			if(cliente.getCodPostal().trim().isEmpty() || cliente.getCodPostal() == null) {
				throw new ErrorServicio("Codigo Postal vacio");
			}
			if(cliente.getCiudad().trim().isEmpty() || cliente.getCiudad() == null) {
				throw new ErrorServicio("Ciudad vacio");
			}
			if(cliente.getPais().trim().isEmpty() || cliente.getPais() == null) {
				throw new ErrorServicio("Pais vacio");
			}
			if(cliente.getNumero() < 0 || cliente.getNumero() == null) {
				throw new ErrorServicio("Numero invalido");
			}
			
			cliente.setUsuario(usuario);
			clienteRepository.save(cliente);
		} catch (ErrorServicio e) {
			throw e;
		}
	}
	
	@Transactional
	public Cliente searchClienteByUsuario(Usuario usuario) throws ErrorServicio{
		try {
			if(usuario == null) {
				throw new ErrorServicio("error");
			}
			Cliente cliente = clienteRepository.findByUsuario(usuario);
			return cliente;
		} catch (ErrorServicio e) {
			return null;
		}catch (NullPointerException e) {
			return null;
		}
	}
}
