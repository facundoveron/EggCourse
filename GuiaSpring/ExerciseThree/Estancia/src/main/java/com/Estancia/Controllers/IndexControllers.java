package com.Estancia.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Entities.Cliente;
import com.Estancia.Entities.Familia;
import com.Estancia.Entities.Usuario;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Service.CasaService;
import com.Estancia.Service.ClienteService;
import com.Estancia.Service.FamiliaService;
import com.Estancia.Service.UsuarioService;

@Controller
@RequestMapping("/")
public class IndexControllers {

	@Autowired
	private CasaService casaService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	FamiliaService familiaService;
	
	@GetMapping("")
	public String index(ModelMap model, HttpSession httpSession) {
		model.addAttribute("paises", casaService.listCountryHouse());
		String auth = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("logueado", auth.equals("anonymousUser"));
		return "Index";
	}

	@GetMapping("alquilarFamilia")
	public String ponerEnAlquiler(ModelMap model, HttpSession session)throws ErrorServicio {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();		
		Usuario usuario = usuarioService.searchByEmail(email); 
		try {
			Familia familia = familiaService.searchFamiliaByUsuario(usuario);
			if (familia == null && usuario.getRole().toString().equals("CLIENTE")) {
				String error = "Esta cuenta esta registrada como CLIENTE, este es el motivo por el cual la pagina marca error. Una posible solucion es que registre una nueva cuenta como FAMILIA. O que en configuraciones cambie su rol a FAMILIA";
				model.put("descripcion", error);
				return "Error";
			}else if (familia == null && usuario.getRole().toString().equals("FAMILIA")){
				return "redirect:/familia/registre";
			}
		} catch (Exception e) {
			return "";
		}
		model.addAttribute("casas", familiaService.listHouseOfFamily(usuario));
		return "Familia";
	}

	@GetMapping("alquilarCliente")
	public String alquilar(ModelMap model, HttpSession session) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			Usuario usuario = usuarioService.searchByEmail(email);
			Cliente cliente = clienteService.searchClienteByUsuario(usuario);
			if (cliente == null && usuario.getRole().toString().equals("FAMILIA")) {
				String error = "Esta cuenta esta registrada como Familia, este es el motivo por el cual la pagina marca error. Una posible solucion es que registre una nueva cuenta como cliente. O que en configuraciones cambie su rol a CLIENTE.";
				model.put("descripcion", error);
				return "Error";
			}else if(cliente == null && usuario.getRole().toString().equals("CLIENTE")) {
				return "redirect:/cliente/registre";
			}
		} catch (Exception e) {
			return "";
		}
		model.put("casas", casaService.listAllCasa());
		return "Casa";
	}

	@GetMapping("/verCasa")
	public String casas() {
		return "redirect:/casa";
	}
}
