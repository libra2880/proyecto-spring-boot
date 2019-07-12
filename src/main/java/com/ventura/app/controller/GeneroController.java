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

import com.ventura.app.model.Genero;
import com.ventura.app.service.GeneroService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class GeneroController {

	
	private GeneroService generoService;

	@Autowired
	public GeneroController(GeneroService generoService) {
		
		this.generoService = generoService;
	}
	
	
	@GetMapping("/genero")
	public String generoLista(Model model) {
		
		model.addAttribute("generos",generoService.generoLista());
		return "mantenimiento/genero";
	}
	
	@PostMapping("/agregargenero")
	@PreAuthorize("hasRole('admin')")
	public String agregarGenero(Model model,@ModelAttribute("generos") Genero genero) throws IOException{
		
		model.addAttribute("generos",generoService.agregarGenero(genero));
		
		return "redirect:/mantenimiento/genero";
	}
	
	
	
	
	
	
}
