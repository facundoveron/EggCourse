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
	
	@GetMapping("/admin")
	public String admi() {
		return "AdmiAuthor.html";
	}
	
	@GetMapping("/list")
	public String list() {
		return "ListAuthor.html";
	}
}
