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

import com.ventura.app.model.Departamento;
import com.ventura.app.service.DepartamentoService;
import com.ventura.app.service.PaisService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class DepartamentoController {

	private DepartamentoService departamentoService;
	
	private PaisService paisService;

	@Autowired
	public DepartamentoController(DepartamentoService departamentoService, PaisService paisService) {
		
		this.departamentoService = departamentoService;
		this.paisService = paisService;
	}
	
	@GetMapping("/departamento")
	public String departamentoListas(Model model) {
		model.addAttribute("departamentos",departamentoService.departamentoLista());
		model.addAttribute("paises",paisService.paisLista());
		
		return "mantenimiento/departamento";
		
	}
	@PostMapping("/agregardepartamento")
	@PreAuthorize("hasRole('admin')")
	public String agregarDepartamento(@ModelAttribute("departamentos") Departamento departamento,Model model) throws IOException{
		
		model.addAttribute("departamentos", departamentoService.agregarDepartamento(departamento).getPais().getNompais());
		return "redirect:/mantenimiento/departamento";
	}
	
	
	
}
