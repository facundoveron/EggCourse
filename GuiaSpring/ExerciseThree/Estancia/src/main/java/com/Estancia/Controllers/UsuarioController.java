package com.Estancia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Entities.Usuario;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/registre")
	public String registre(ModelMap model) {
		model.put("usuario", new Usuario());
		return "Registro";
	}
	
	@PostMapping("/registre")
	public String registre(ModelMap model, @ModelAttribute Usuario usuario) {
		try {
			usuarioService.registrar(usuario);
		} catch (ErrorServicio e) {
			model.put("error", e.getMessage());
			model.put("email", usuario.getEmail());
			model.put("alias", usuario.getAlias());
			return "Registro";
		}
		return "redirect:/";
	}
}
