package com.Estancia.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Entities.Usuario;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("")
	public String login() {
		return "Login";
	}
	
	@PostMapping("")
	public String login(@ModelAttribute Usuario usuario) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
}
