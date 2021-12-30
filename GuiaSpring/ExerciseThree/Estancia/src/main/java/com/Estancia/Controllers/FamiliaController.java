package com.Estancia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Entities.Familia;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Service.FamiliaService;
import com.Estancia.Service.UsuarioService;

@Controller
@RequestMapping("/familia")
@PreAuthorize("hasRole ('FAMILIA')")
public class FamiliaController {
	
	@Autowired
	private FamiliaService familiaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public String indexFamilia(ModelMap model) {
		try {
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			if(familiaService.searchFamiliaByUsuario(usuarioService.searchByEmail(email)) == null) {
				return "redirect:/familia/registre";
			}
		} catch (Exception e) {
			String error = "error en el sistema a la hora de verificar tu rol";
			model.addAttribute("descripcion", error);
			return "Error";
		}
		return "Familia";
	}
	
	@GetMapping("/registre")
	public String registrarFamilia(ModelMap model) {
		model.addAttribute("familia", new Familia());
		return "RegistrarFamilia";
	}
	
	@PostMapping("/registre")
	public String registre(ModelMap model, @ModelAttribute Familia familia) throws ErrorServicio{
		try {
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			familiaService.registreFamilia(familia, usuarioService.searchByEmail(email));
		} catch (ErrorServicio e) {
			model.put("error", e.getMessage());
			model.put("nombre", familia.getNombre());
			model.put("edadMin", familia.getEdadMin());
			model.put("edadMax", familia.getEdadMax());
			model.put("numHijos", familia.getNumHijos());
			return "RegistrarFamilia";
		}
		return "Familia";
	}
	
}
