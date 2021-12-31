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
import com.Estancia.Service.CasaService;
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
	
	@Autowired
	private CasaService casaService;
	
	@GetMapping("")
	public String cliente(ModelMap model) {
		try {
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			if(clienteService.searchClienteByUsuario(usuarioService.searchByEmail(email)) == null) {
				return "redirect:/cliente/registre";
			}
		} catch (Exception e) {
			String error = "error en el sistema a la hora de verificar tu rol";
			model.addAttribute("descripcion", error);
			return "Error";
		}
		model.put("casas", casaService.listAllCasa());
		return "Casa";
	}
	
	@GetMapping("/registre")
	public String registrarCliente(ModelMap model) {
		model.put("cliente", new Cliente());
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
