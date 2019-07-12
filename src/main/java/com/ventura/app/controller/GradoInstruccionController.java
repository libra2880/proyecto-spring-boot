package com.ventura.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ventura.app.model.GradoInstruccion;
import com.ventura.app.service.GradoInstruccionService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class GradoInstruccionController {

	
	private GradoInstruccionService gradoInstruccionService;

	@Autowired
	public GradoInstruccionController(GradoInstruccionService gradoInstruccionService) {
		
		this.gradoInstruccionService = gradoInstruccionService;
	}
	
	@GetMapping("/gradoinstruccion")
	public String gradoInstruccionLista(Model model) {
		model.addAttribute("gradoinstruccions",gradoInstruccionService.gInstruccionLista());
		return "mantenimiento/gradoinstruccion";
	}
	@PostMapping("/agregargradoinstruccion")
	@PreAuthorize("hasRole('admin')")
	public String agregarGInstruccion(@ModelAttribute("gradoinstruccions") GradoInstruccion gInstruccion,Model model) {
		model.addAttribute("gradoinstruccions",gradoInstruccionService.agregarGInstruccion(gInstruccion));
	
	return "redirect:/mantenimiento/gradoinstruccion";
	}
}
