
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

import com.ventura.app.model.Provincia;
import com.ventura.app.service.DepartamentoService;
import com.ventura.app.service.ProvinciaService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class ProvinciaController {

	private ProvinciaService provinciaService;
	
	private DepartamentoService departamentoService;

	@Autowired
	public ProvinciaController(ProvinciaService provinciaService, DepartamentoService departamentoService) {
		
		this.provinciaService = provinciaService;
		this.departamentoService = departamentoService;
	}
	
	@GetMapping("/provincia")
	public String provinciaListas(Model model) {
		model.addAttribute("departamentos", departamentoService.departamentoLista());
		model.addAttribute("provincias",provinciaService.provinciaLista());
		return"mantenimiento/provincia";
	}
	
	@PostMapping("/agregarprovincia")
	@PreAuthorize("hasRole('admin')")
	public String agregarProvincia(@ModelAttribute("provincias") Provincia provincia,Model model) throws IOException {
		
		model.addAttribute("provincias",provinciaService.agregarProvincia(provincia));
		return "redirect:/mantenimiento/provincia";
		
	}
}
