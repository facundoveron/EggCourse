package com.Libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Libreria.error.ErrorService;
import com.Libreria.service.AutorService;

@Controller
@RequestMapping("/list")
public class ListController {
	
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
	public String unsubscribeAuthor(@PathVariable("parametro") String parametro) throws ErrorService{
		try {
			autorService.cancelAuthor(parametro);
		} catch (Exception e) {
			throw e;
		}
		return "redirect:/list/mostrar";
	}
}
