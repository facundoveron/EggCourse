package com.Libreria.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libreria.entities.Editorial;
import com.Libreria.error.ErrorService;
import com.Libreria.repository.PublisherRepository;

@Service
public class EditorialService {
	
	@Autowired
	PublisherRepository publisherRepository;
	
	
	@Transactional
	public void createPublisher(String name) throws ErrorService {
		try {
			if(name == null || name.trim().isEmpty()) {
				throw new ErrorService("name null or empty");
			}
			if(searchByName(name) != null) {
				throw new ErrorService("Publisher's name already registered");
			}
			
			Editorial publisher = new Editorial();
			publisher.setNombre(name);
			publisher.setAlta(true);
			publisherRepository.save(publisher);
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	
	@Transactional
	public Editorial searchByName(String name) throws ErrorService {
		try {
			if(name == null || name.trim().isEmpty()) {
				throw new ErrorService("name null or empty");				
			}
			return publisherRepository.findByNombre(name.toLowerCase());
		}catch (NullPointerException e) {
			return null;
		} catch (ErrorService e) {
			throw e;
		}		
	}
	
	@Transactional
	public Collection<Editorial> listPublisher() throws ErrorService{
		try {
			Collection<Editorial> listEditorials = publisherRepository.findAll();
			if(listEditorials.size() == 0) {
				throw new ErrorService(" no found publishers");
			}
			return listEditorials;
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	
	@Transactional
	public void cancelPublisher(String nombre) throws ErrorService{
		try {
			if(nombre == null || nombre.trim().isEmpty()) {
				throw new ErrorService("name null o empyt");
			}
			Editorial publisher = searchByName(nombre);
			publisher.setAlta(false);
			publisherRepository.save(publisher);
		} catch (ErrorService e) {
			throw e;
		}
	}
}
