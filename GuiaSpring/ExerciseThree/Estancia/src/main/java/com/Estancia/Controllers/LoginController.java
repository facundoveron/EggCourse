package com.Estancia.Controllers;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Entities.Usuario;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Service.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private Log log = LogFactory.getLog(LoginController.class);

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public String login(Model model) {
		log.info("entro al login");
		model.addAttribute("usuario", new Usuario());
		return "Login";
	}
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		return "redirect:/user/registre";
	}
	
	@GetMapping("/loginsuccess")
	public String logincheck(HttpSession session) throws ErrorServicio{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			if (auth == null) {
				return "redirect:/login";
			}else {
				if(usuarioService.role(auth.getName())) {
					return "redirect:/familia";
				}else {
					return "redirect:/cliente";				
				}
			}
		} catch (Exception e) {
			return "Error";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
	
}
