package com.Estancia.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Entities.Cliente;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Service.ClienteService;
import com.Estancia.Service.UsuarioService;

@Controller
@RequestMapping("/cliente")
@PreAuthorize("hasRole ('CLIENTE')")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public String cliente(ModelMap model) {
		model.addAttribute("cliente", new Cliente());
		return "Cliente";
	}
	
	@PostMapping("/registre")
	public String registre(ModelMap model,@ModelAttribute Cliente cliente, HttpSession httpSession) throws ErrorServicio{
		try {
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			clienteService.registrarCliente(cliente, usuarioService.searchByEmail(email));
		} catch (ErrorServicio e) {
			model.put("error", e.getMessage());
			model.put("nombre", cliente.getNombre());
			model.put("ciudad", cliente.getCiudad());
			model.put("pais", cliente.getPais());
			model.put("calle", cliente.getCalle());
			model.put("codPostal", cliente.getCodPostal());
			model.put("numero", cliente.getNumero());
			return "Cliente";
		}
		return "redirect:/";
	}
	
}
