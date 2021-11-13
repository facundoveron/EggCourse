package com.Libreria.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Libreria.error.ErrorService;
import com.Libreria.service.PrestamoService;

@Controller
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	PrestamoService prestamoService;

	@GetMapping("/")
	public String loan() {
		return "Loan.html";
	}
	
	
	@PostMapping("/addMain")
	public String addMain(ModelMap model,@RequestParam(required = false) Long dni, @RequestParam(required = false) Long isbn,@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfReturn)throws ErrorService {
		try {
			prestamoService.createLoanMain(dni, isbn, dateOfReturn);
		} catch (ErrorService e) {
			model.put("error", e.getMessage());
			model.put("dni", dni);
			model.put("isbn", isbn);
			model.put("dateOfReturn", dateOfReturn);
			return "Loan.html";
		}
		return "redirect:/loan/";
	}
	
	@PostMapping("/addSecondary")
	public String addMain(ModelMap model,@RequestParam(required = true) String phone, @RequestParam(required = true) String title, @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd")  Date dateOfReturn)throws ErrorService {
		try {
			prestamoService.createLoanSecondary(phone, title, dateOfReturn);
		} catch (ErrorService e) {
			model.put("error2", e.getMessage());
			model.put("phone", phone);
			model.put("title", title);
			model.put("dateOfReturn", dateOfReturn);
			return "Loan.html";
		}
		return "redirect:/loan/";
	}
}
