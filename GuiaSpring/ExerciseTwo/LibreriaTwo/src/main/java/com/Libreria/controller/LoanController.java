package com.Libreria.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Libreria.entities.Prestamo;
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
	
	
	@GetMapping("/list")
	public String list(ModelMap model) throws ErrorService{
		try {
			model.addAttribute("loan", prestamoService.listAll());
		} catch (ErrorService e) {
			throw e;
		}
		return "ListLoan.html";
	}
	
	@PostMapping("baja/{parametro}")
	public String cancel(ModelMap model, @PathVariable("parametro") String id)throws ErrorService{
		try {
			prestamoService.cancelLoan(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/loan/list";
	}
	
	@PostMapping("edit/{parametro}")
	public String edit(ModelMap model, @PathVariable("parametro") String id)throws ErrorService{
		try {
			Prestamo prestamo = prestamoService.searchById(id);
			model.addAttribute("prestamo", prestamo);
			model.addAttribute("loan", prestamoService.listAll());			
			return "ListLoan.html";
		} catch (Exception e) {
			model.put("error", e.getMessage());
			return "ListLoan.html";
		}
	}
	
	@PostMapping("edit/update/{parametro}")
	public String update(ModelMap model, @PathVariable("parametro") String id, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")  Date dateUpdate) throws ErrorService{
		try {
			prestamoService.updateDate(id, dateUpdate);
		} catch (ErrorService e) {
			model.put("error", e.getMessage());
			model.put("dateOfReturn", dateUpdate);
			return "ListLona.html";
		}
		return "redirect:/loan/list";
	}
}
