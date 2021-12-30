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

import com.Estancia.Entities.Cliente;
import com.Estancia.Service.CasaService;
import com.Estancia.Service.ClienteService;
import com.Estancia.Service.UsuarioService;

@Controller
@RequestMapping("/")
public class IndexControllers {

	private Log log = LogFactory.getLog(IndexControllers.class);

	@Autowired
	private CasaService casaService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("")
	public String index(ModelMap model, HttpSession httpSession) {
		model.addAttribute("paises", casaService.listCountryHouse());
		String auth = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("logueado", auth.equals("anonymousUser"));
		return "Index";
	}

	@GetMapping("alquilarFamilia")
	public String ponerEnAlquiler(ModelMap model, HttpSession session) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();		
		try {
			if (clienteService.searchClienteByUsuario(usuarioService.searchByEmail(email)) == null) {
				String error = "Esta cuenta esta registrada como Familia, este es el motivo por el cual la pagina marca error. Una posible solucion es que registre una nueva cuenta como cliente. O que en configuraciones cambie su rol a CLIENTE";
				model.put("descripcion", error);
				return "Error";
			}
		} catch (Exception e) {
			return "";
		}
		return "AlquilarCasas";
	}

	@GetMapping("alquilarCliente")
	public String alquilar(ModelMap model, HttpSession session) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			if (clienteService.searchClienteByUsuario(usuarioService.searchByEmail(email)) == null) {
				String error = "Esta cuenta esta registrada como Familia, este es el motivo por el cual la pagina marca error. Una posible solucion es que registre una nueva cuenta como cliente. O que en configuraciones cambie su rol a CLIENTE.";
				model.put("descripcion", error);
				return "Error";
			}
		} catch (Exception e) {
			return "";
		}
		return "AlquilarCasas";
	}

	@GetMapping("/verCasa")
	public String casas() {
		return "redirect:/casa";
	}
}
