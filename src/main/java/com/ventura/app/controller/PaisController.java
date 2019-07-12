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

import com.ventura.app.model.Pais;
import com.ventura.app.service.PaisService;


@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class PaisController {

	private PaisService paisService;

	@Autowired
	public PaisController(PaisService paisService) {
		
		this.paisService = paisService;
	}
	
	@GetMapping("/pais")
	public String paisLista(Model model) {
		
		model.addAttribute("paises",paisService.paisLista());
		return"mantenimiento/pais";
	}
	@PostMapping("/agregarpais")
	@PreAuthorize("hasRole('admin')")
	public String agregarPais(@ModelAttribute("paises") Pais pais,Model model) throws IOException{
		model.addAttribute("paises",paisService.agregarPais(pais));
		return "redirect:/mantenimiento/pais";
		
	}
	
	/*@RequestMapping(value="/")
	public String cargarDepartamento() {*/
		
		
		
	
	
	
}
