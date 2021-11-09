package com.Libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Libreria.error.ErrorService;
import com.Libreria.service.PublisherService;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
	
	@Autowired
	PublisherService publisherService;
	
	@PostMapping("")
	public String savePublisher(ModelMap modelo, @RequestParam(required = true) String name)throws ErrorService {
		try {
			publisherService.createPublisher(name);
		} catch (ErrorService e) {
			modelo.put("error", e.getMessage());
		}
		return "";
	}
}
