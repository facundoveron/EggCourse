package com.Estancia.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/familia")
@PreAuthorize("hasRole ('FAMILIA')")
public class FamiliaController {
	
	@GetMapping("")
	public String indexFamilia(ModelMap model) {
		return "Familia";
	}
}
