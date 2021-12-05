package com.Estancia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Service.CasaService;

@Controller
@RequestMapping("/casa")
public class CasaController {
	
	@Autowired
	private CasaService casaService;
	
	@GetMapping("")
	public String listCasas(ModelMap model) {
		model.addAttribute("casas", casaService.listAllCasa());
		return "Casa";
	}
}
