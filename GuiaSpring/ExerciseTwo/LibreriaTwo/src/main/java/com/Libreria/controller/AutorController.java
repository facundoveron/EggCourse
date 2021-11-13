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
import com.Libreria.service.AutorService;

@Controller
@RequestMapping("/author")
public class AutorController {

	@Autowired
	AutorService autorService;
	
	@GetMapping("/mostrar")
	public String listAuthor(ModelMap modelo) throws ErrorService {
		try {
			modelo.addAttribute("autor", autorService.listAuthor());
		} catch (ErrorService e) {
			throw e;
		}
		return "ListAuthor.html";
	}
	
	@PostMapping("/baja/{parametro}")
	public String unsubscribeAuthor(ModelMap model,@PathVariable("parametro") String parametro) throws ErrorService{
		try {
			autorService.cancelAuthor(parametro);
		} catch (Exception e) {
			model.put("error", e.getMessage());
			return "ListAuthor.html";
		}
		return "redirect:/author/mostrar";
	}
	
	@GetMapping("/admin")
	public String addAuthor() {
		return "AdmiAuthor.html";
	}
	
	@PostMapping("/add")
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
		
		return "redirect:/author/mostrar";
	}
}
