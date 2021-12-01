package com.Estancia.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexControllers {

	@GetMapping("")
	public String index() {
		return "Index";
	}
}
