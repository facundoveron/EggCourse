package com.Libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Libreria.error.ErrorService;
import com.Libreria.service.EditorialService;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
	
	@Autowired
	EditorialService editorialService;
	
	@GetMapping("/")
	public String publisher(ModelMap modelo) throws ErrorService {
		try {
			modelo.addAttribute("editorial", editorialService.listPublisher());
			return "Publisher.html";			
		} catch (ErrorService e) {
			throw e;
		}
	}
	
	@PostMapping("/add")
	public String savePublisher(ModelMap modelo, @RequestParam(required = true) String nombre)throws ErrorService {
		try {
			editorialService.createPublisher(nombre);
		} catch (ErrorService e) {
			modelo.put("error", e.getMessage());			
			modelo.addAttribute("editorial", editorialService.listPublisher());
			return "Publisher.html";
		}
		return "redirect:/publisher/";
	}
	
	@PostMapping("/baja/{parametro}")
	public String cancelPublisher(ModelMap modelo, @PathVariable("parametro") String nombre) throws ErrorService{
		try {
			editorialService.cancelPublisher(nombre);
		} catch (ErrorService e) {
			modelo.put("error", e.getMessage());			
			modelo.addAttribute("editorial", editorialService.listPublisher());
			return "Publisher.html";
		}
		return "redirect:/publisher/";
	}
	
	
	
}
