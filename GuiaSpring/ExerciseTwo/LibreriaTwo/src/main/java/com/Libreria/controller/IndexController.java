package com.Libreria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "Index.html";
	}
	
	@GetMapping("/author")
	public String author() {
		return "Author.html";
	}
	
	@GetMapping("/publisher")
	public String publisher() {
		return "Publisher.html";
	}
	
	@GetMapping("/book")
	public String book() {
		return "Book.html";
	}
	
	@GetMapping("/loan")
	public String loan() {
		return "Loan.html";
	}
	
	@GetMapping("/customer")
	public String customer() {
		return "Customer.html";
	}
}
