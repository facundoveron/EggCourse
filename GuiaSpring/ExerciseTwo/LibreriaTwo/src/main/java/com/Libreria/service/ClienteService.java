package com.Libreria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libreria.entities.Cliente;
import com.Libreria.error.ErrorService;
import com.Libreria.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente searchByDni(Long dni) throws ErrorService{
		try {
			if(dni == null) {
				throw new ErrorService("dni null");
			}
			Cliente cliente = clienteRepository.findByDocumento(dni);
			return cliente;
		}catch (NullPointerException e) {
			return null;
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	
	@Transactional
	public Cliente searchByPhone(String phone) throws ErrorService{
		try {
			if(phone == null || phone.trim().isEmpty()) {
				throw new ErrorService("phone null or phone empty");
			}
			Cliente cliente = clienteRepository.findByTelefono(phone);
			return cliente;
		}catch (NullPointerException e) {
			return null;
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	@Transactional
	public void createCustomer(Long dni, String name, String lastName, String phone) throws ErrorService{
		try {
			if(dni == null) {
				throw new ErrorService("dni null");
			}
			if(name == null || name.trim().isEmpty()) {
				throw new ErrorService("name null or name empty");
			}
			if(lastName == null || lastName.trim().isEmpty()) {
				throw new ErrorService("last name null or empty");
			}
			if(phone == null || phone.trim().isEmpty()) {
				throw new ErrorService("phone null or empty");
			}
			
			if(searchByDni(dni) != null) {
				throw new ErrorService("dni already registered");
			}
			
			if(searchByPhone(phone) != null) {
				throw new ErrorService("phone already registered");
			}
			
			Cliente cliente = new Cliente();
			cliente.setDocumento(dni);
			cliente.setNombre(name);
			cliente.setApellido(lastName);
			cliente.setTelefono(phone);
			cliente.setAlta(true);
			
			clienteRepository.save(cliente);
		} catch (NullPointerException e) {
			throw new ErrorService("error sistema");
		} catch (ErrorService e) {
			throw e;
		}
	}
}
