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

import com.ventura.app.model.Distrito;

import com.ventura.app.service.DistritoService;
import com.ventura.app.service.ProvinciaService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class DistritoController {

			private DistritoService distritoService;
			
			private ProvinciaService provinciaService;

			@Autowired
			public DistritoController(DistritoService distritoService, ProvinciaService provinciaService) {
				
				this.distritoService = distritoService;
				this.provinciaService = provinciaService;
			}
			
			
	
			@GetMapping("/distrito")
			public String distroLista(Model model) {
				model.addAttribute("distritos",distritoService.distritoLista());
				model.addAttribute("provincias",provinciaService.provinciaLista()); 
				
				return "mantenimiento/distrito";
				
			}
			
		

			@PostMapping("/agregardistrito")
			@PreAuthorize("hasRole('admin')")
			public String agregarDistrito(@ModelAttribute("distritos") Distrito distrito,Model model) throws IOException {
				
				
				model.addAttribute("distritos",distritoService.agregarDistrito(distrito).getProvincia().getNomprovincia());
				
				return "redirect:/mantenimiento/distrito";
				
			}
	
}
