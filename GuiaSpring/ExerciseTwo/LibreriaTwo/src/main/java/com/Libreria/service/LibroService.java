package com.Libreria.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libreria.entities.Autor;
import com.Libreria.entities.Editorial;
import com.Libreria.entities.Libro;
import com.Libreria.error.ErrorService;
import com.Libreria.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	LibroRepository libroRepository;
	
	@Autowired
	AutorService autorService;
	
	@Autowired
	EditorialService editorialService;
	
	@Transactional
	public Collection<Libro> listAllBooks () throws ErrorService{
		try {
			Collection<Libro> books = libroRepository.findAll();
			if(books == null) {
				throw new ErrorService("no found books");
			}
			return books;
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	@Transactional
	public void createBook(String nameAuthor, String namePublisher, String title, Long isbn, Integer year, Integer copies) throws ErrorService{
		try {
			if(nameAuthor == null || nameAuthor.trim().isEmpty()) {
				throw new ErrorService("name author null or empty");
			}
			if(namePublisher == null || namePublisher.trim().isEmpty()) {
				throw new ErrorService("name publisher null or empty");
			}
			if(title == null || title.trim().isEmpty()) {
				throw new ErrorService("title null or empty");
			}
			if(isbn == null) {
				throw new ErrorService("isbn null");
			}
			if(year == null || year < 1900) {
				throw new ErrorService("year null or year less than 1900");
			}
			if(copies == null || copies < 1) {
				throw new ErrorService("copies null or copies less than 0");
			}
			if(searchBookByTitle(title) != null) {
				throw new ErrorService("Title already registered");
			}
		
			
			Autor autor = autorService.searchByName(nameAuthor);
			if(autor == null) {
				throw new ErrorService("Unregistered author");
			}
			
			Editorial editorial = editorialService.searchByName(namePublisher);
			if(editorial == null) {
				throw new ErrorService("Unregistered publisher");
			}
			
			
			Libro libro = new Libro();
			libro.setIsbn(isbn);
			libro.setTitulo(title);
			libro.setAnio(year);
			libro.setEjemplares(copies);
			libro.setEjemplaresPrestados(0);
			libro.setEjemplaresRestantes(copies);
			libro.setAlta(true);
			libro.setAutor(autor);
			libro.setEditorial(editorial);
			
			libroRepository.save(libro);
		} catch (NumberFormatException e) {
			throw new ErrorService("isbn invalido");
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	@Transactional
	public void update(String nameAuthor, String namePublisher, String title, Long isbn, Integer year, Integer copies, Libro libro) throws ErrorService{
		try {
			if(nameAuthor == null || nameAuthor.trim().isEmpty()) {
				throw new ErrorService("name author null or empty");
			}
			if(namePublisher == null || namePublisher.trim().isEmpty()) {
				throw new ErrorService("name publisher null or empty");
			}
			if(title == null || title.trim().isEmpty()) {
				throw new ErrorService("title null or empty");
			}
			if(isbn == null) {
				throw new ErrorService("isbn null");
			}
			if(year == null || year < 1900) {
				throw new ErrorService("year null or year less than 1900");
			}
			if(copies == null || copies < 1) {
				throw new ErrorService("copies null or copies less than 0");
			}
			if(searchBookByTitle(title) != null) {
				throw new ErrorService("Title already registered");
			}
			
			
			Autor autor = autorService.searchByName(nameAuthor);
			if(autor == null) {
				throw new ErrorService("Unregistered author");
			}
			
			Editorial editorial = editorialService.searchByName(namePublisher);
			if(editorial == null) {
				throw new ErrorService("Unregistered publisher");
			}
			
			
			libro.setIsbn(isbn);
			libro.setTitulo(title);
			libro.setAnio(year);
			libro.setEjemplares(copies);
			libro.setEjemplaresPrestados(0);
			libro.setEjemplaresRestantes(copies);
			libro.setAlta(true);
			libro.setAutor(autor);
			libro.setEditorial(editorial);
			
			libroRepository.save(libro);
		}catch (NullPointerException e) {
			throw new ErrorService("error service");
		} catch (NumberFormatException e) {
			throw new ErrorService("isbn invalido");
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	@Transactional
	public Libro searchBookByTitle(String title) throws ErrorService{
		try {
			if(title == null || title.trim().isEmpty()) {
				throw new ErrorService("title null o empty");
			}
			return libroRepository.findByTitulo(title);
		} catch (NullPointerException e) {
			return null;	
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	@Transactional
	public Libro searchBookByIsbn(Long isbn) throws ErrorService{
		try {
			if(isbn == null) {
				throw new ErrorService("isbn null");
			}
			Libro libro = libroRepository.findByIsbn(isbn);
			return libro;
		} catch (NullPointerException e) {
			return null;	
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	@Transactional
	public void cancelBook(String title) throws ErrorService{
		try {
			if(title == null || title.trim().isEmpty()) {
				throw new ErrorService("title null o empty");
			}
			
			Libro libro = searchBookByTitle(title);
			if(libro == null) {
				throw new ErrorService("not found book");
			}
			libro.setAlta(false);
			libroRepository.save(libro);
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	@Transactional
	public void loanBook(Libro libro) throws ErrorService{
		try {
			if(libro == null) {
				throw new ErrorService("book null");
			}
			
			libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
			libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
			libroRepository.save(libro);
		} catch (ErrorService e) {
			throw e;
		}
	}
}
