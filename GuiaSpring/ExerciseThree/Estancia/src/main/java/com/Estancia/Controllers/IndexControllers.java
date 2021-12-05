package com.Estancia.Controllers;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Service.CasaService;

@Controller
@RequestMapping("/")
public class IndexControllers {
	
	private Log log = LogFactory.getLog(IndexControllers.class);
	@Autowired
	private CasaService casaService;
	
	@GetMapping("")
	public String index(ModelMap model, HttpSession httpSession) {
		model.addAttribute("paises", casaService.listCountryHouse());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("logueado", auth.getName().equals("anonymousUser"));
		return "Index";
	}
	
	@GetMapping("alquilarFamilia")
	public String ponerEnAlquiler() {
		return "redirect:/familia";
	}
	
	@GetMapping("alquilarCliente")
	public String alquilar() {
		return "redirect:/cliente";
	}
	
	@GetMapping("/verCasa")
	public String casas() {
		return "redirect:/casa";
	}
}
