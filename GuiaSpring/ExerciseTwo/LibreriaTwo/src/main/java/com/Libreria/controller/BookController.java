package com.Libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Libreria.entities.Libro;
import com.Libreria.error.ErrorService;
import com.Libreria.service.LibroService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	LibroService libroService;

	@GetMapping("/")
	public String book(ModelMap model) throws ErrorService {
		try {
			model.addAttribute("books", libroService.listAllBooks());
		} catch (ErrorService e) {
			model.put("error", e.getMessage());
		}
		return "Book.html";
	}

	@PostMapping("/add")
	public String add(ModelMap model, @RequestParam(required = true) String nameAuthor,
			@RequestParam(required = true) String namePublisher, @RequestParam(required = true) String title,
			@RequestParam(required = false ) Long isbn, @RequestParam(required = false) Integer year,
			@RequestParam(required = false) Integer copies) throws ErrorService{
		try {
			libroService.createBook(nameAuthor, namePublisher, title, isbn, year, copies);
		} catch (ErrorService e) {
			model.put("error", e.getMessage());
			model.put("nombreAuthor", nameAuthor);
			model.put("nombrePublisher", namePublisher);
			model.put("title", title);
			model.put("isbn", isbn);
			model.put("year", year);
			model.put("copies", copies);
			model.addAttribute("books", libroService.listAllBooks());		
			return "Book.html";
		}
		return "redirect:/book/";
	}
	
	
	@PostMapping("/baja/{parametro}")
	public String cancel(ModelMap model, @PathVariable("parametro") String title)throws ErrorService {
		try {
			libroService.cancelBook(title);
		} catch (ErrorService e) {
			model.put("error", e.getMessage());
			return "Book.html";
		}
		return "redirect:/book/";
	}

	
	@PostMapping("/edit/{parametro}")
	public String edit(ModelMap model, @PathVariable("parametro") String title) throws ErrorService{
		try {
			Libro libro = libroService.searchBookByTitle(title);
			model.addAttribute("book", libro);
			return "Book.html";
		} catch (ErrorService e) {
			model.put("error", e.getMessage());
			return "Book.html";
		}		
	}
	
	@PostMapping("/edit/update/{parametro}")
	public String update(ModelMap model, @RequestParam(required = true) String nameAuthor,
			@RequestParam(required = true) String namePublisher, @RequestParam(required = true) String title,
			@RequestParam(required = false ) Long isbn, @RequestParam(required = false) Integer year,
			@RequestParam(required = false) Integer copies, @PathVariable("parametro") String titulo) throws ErrorService{
		try {
			Libro libro = libroService.searchBookByTitle(titulo);
			libroService.update(nameAuthor, namePublisher, title, isbn, year, copies, libro);
		} catch (ErrorService e) {
			
			model.put("error", e.getMessage());
			model.put("nombreAuthor", nameAuthor);
			model.put("nombrePublisher", namePublisher);
			model.put("title", title);
			model.put("isbn", isbn);
			model.put("year", year);
			model.put("copies", copies);
			model.addAttribute("books", libroService.listAllBooks());		
			return "Book.html";
		}
		return "redirect:/book/";
	}
}
