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

import com.ventura.app.model.TipoCliente;
import com.ventura.app.service.TipoClienteService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class TipoClienteController {

	private TipoClienteService tClienteService;

	@Autowired
	public TipoClienteController(TipoClienteService tClienteService) {
		
		this.tClienteService = tClienteService;
	}
	
	@GetMapping("/tipocliente")	
	public String tipoClienteLista(Model model) {
		model.addAttribute("tipoclientes",tClienteService.tClienteLista());
		return "mantenimiento/tipocliente";
		
	}
	
	@PostMapping("/agregartipocliente")
	@PreAuthorize("hasRole('admin')")
	public String agregarTCliente(@ModelAttribute("tipoclientes") TipoCliente tipocliente,Model model) throws IOException
	{
		model.addAttribute("tipoclientes",tClienteService.agregarTCliente(tipocliente));
		return "redirect:/mantenimiento/tipocliente";
		
	}
	
	
	
}
