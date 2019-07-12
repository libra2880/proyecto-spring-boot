package com.ventura.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ventura.app.model.EstadoCivil;
import com.ventura.app.service.EstadoCivilService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class EstadoCivilController {

	private EstadoCivilService estadoCivilService;

	@Autowired
	public EstadoCivilController(EstadoCivilService estadoCivilService) {
	
		this.estadoCivilService = estadoCivilService;
	}
	
	@GetMapping("/estadocivil")
	public String estadoCivilLista(Model model) {
		
		model.addAttribute("estadocivils",estadoCivilService.estadoCivilLista());
		return "mantenimiento/estadocivil";
	}
	
	@PostMapping("/agregarestadocivil")
	@PreAuthorize("hasRole('admin')")	
	public String agregarEstadoCivil(Model model,@ModelAttribute("estadocivils") EstadoCivil estadocivil) throws IOException {
		
		model.addAttribute("estadocivils", estadoCivilService.agregarECivil(estadocivil));
		
	return "redirect:/mantenimiento/estadocivil";
	}
	
	
}
