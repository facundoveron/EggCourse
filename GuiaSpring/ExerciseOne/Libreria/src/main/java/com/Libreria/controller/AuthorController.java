package com.Libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Libreria.error.ErrorService;
import com.Libreria.service.AutorService;

@Controller
@RequestMapping("/admin")public class AuthorController {
	
	@Autowired
	AutorService autorService;

	@PostMapping("/")
	public String addAuthor(ModelMap modelo, @RequestParam(required = true) 
	String nombre, @RequestParam(required = true) String apellido) throws ErrorService{
		try {
			autorService.saveAuthor(nombre, apellido);
		} catch (ErrorService e) {
			modelo.put("error", e.getMessage());
			modelo.put("nombre", nombre);
			modelo.put("apellido", apellido);
			return "AdmiAuthor.html";
		}
		
		return "Index.html";
	}
}
