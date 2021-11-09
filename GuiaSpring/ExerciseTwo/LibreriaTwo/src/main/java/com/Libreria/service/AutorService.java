package com.Libreria.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libreria.entities.Autor;
import com.Libreria.error.ErrorService;
import com.Libreria.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	/**
	 * Method creating and saving an author
	 * 
	 * @param nombre
	 * @param apellido
	 * @throws ErrorService
	 */
	@Transactional
	public void saveAuthor(String nombre, String apellido) throws ErrorService{
		try {
			if(nombre == null || nombre.trim().isEmpty()) {
				throw new ErrorService("Name null or empty");
			}
			if(apellido == null || apellido.trim().isEmpty()) {
				throw new ErrorService("LastName null or empty");
			}
			String name = nombre + " " + apellido;
			if(searchByName(name) != null) {
				throw new ErrorService("Author already registered");
			}
			
			Autor autor = new Autor();
			autor.setNombre(nombre + " " + apellido);
			autor.setAlta(true);
			autorRepository.save(autor);
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	/**
	 * Method that lists all authors
	 * 
	 * @return lisAuthors
	 * @throws ErrorService
	 */
	@Transactional
	public Collection<Autor> listAuthor() throws ErrorService {
		try {
			Collection<Autor> lisAuthors= autorRepository.findAll();
			if(lisAuthors.size() == 0) {
				throw new ErrorService("no found author");
			}
			return lisAuthors;
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	
	/**
	 * Method that searches for an author by name
	 * 
	 * @param nombre
	 * @return autorRepository.findByNombre(nombre)
	 * @throws ErrorService
	 */
	@Transactional
	public Autor searchByName(String nombre) throws ErrorService{
		try {
			if(nombre == null || nombre.trim().isEmpty()) {
				throw new ErrorService("name null or empty");
			}
			
			return autorRepository.findByNombre(nombre);
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	
	/**
	 * Method that searches for an author by name and unsubscribes him or her
	 * 
	 * @param nombre
	 * @throws ErrorService
	 */
	@Transactional
	public void cancelAuthor(String nombre) throws ErrorService {
		try {
			Autor autor = searchByName(nombre);
			autor.setAlta(false);
			autorRepository.save(autor);
		} catch (ErrorService e) {
			throw e;
		}
	}
}
