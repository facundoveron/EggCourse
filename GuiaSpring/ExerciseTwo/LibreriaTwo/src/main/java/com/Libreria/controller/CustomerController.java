package com.Libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Libreria.error.ErrorService;
import com.Libreria.service.ClienteService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/")
	public String customer() {
		return "Customer.html";
	}

	@PostMapping("/add")
	public String add(ModelMap modelo, @RequestParam(required = false) Long dni,
			@RequestParam(required = true) String name, @RequestParam(required = true) String lastName,
			@RequestParam(required = true) String phone) throws ErrorService {
		try {
			clienteService.createCustomer(dni, name, lastName, phone);
		} catch (ErrorService e) {
			modelo.put("error", e.getMessage());
			modelo.put("dni", dni);
			modelo.put("name", name);
			modelo.put("lastName", lastName);
			modelo.put("phone", phone);
			return "Customer.html";
		}
		return "redirect:/customer/";
	}
}
