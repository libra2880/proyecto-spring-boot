package com.ventura.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BienvenidoController {
	
	@RequestMapping("/")
	public String bienvenido(Model model){
		
		model.addAttribute("mensaje","Inicio Spring Boot");
		return "inicio";
	}
	
}
