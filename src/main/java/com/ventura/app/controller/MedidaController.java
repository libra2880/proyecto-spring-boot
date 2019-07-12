package com.ventura.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ventura.app.model.Medida;
import com.ventura.app.service.MedidaService;

@RequestMapping("/medida")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class MedidaController {
	
	private MedidaService medidaService;

	@Autowired
	public MedidaController(MedidaService medidaService) {
	
		this.medidaService = medidaService;
	}
	
	@GetMapping("/lista")
	public String medidaLista(Model model){
		model.addAttribute("medidas",medidaService.medidaLista());
		return "medida/lista";
	}

	@PostMapping("/agregar")
	@PreAuthorize("hasRole('admin')")
	public String agregarMedida(@ModelAttribute("medidas") Medida medida,Model model)throws IOException {
		model.addAttribute("medidas",medidaService.agregarMedida(medida));
		return "redirect:/medida/lista";
	}
	
	@GetMapping("/actualizar/{id}")
	@PreAuthorize("hasRole('admin')")
	public String actualizarMedida(@PathVariable Long id,Model model){
		
		model.addAttribute("medida", medidaService.getMedida(id));
		return "medida/lista";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminarMedida(@PathVariable  Long id,Model model){
		model.addAttribute("mensaje",medidaService.eliminarMedida(id));
		return "redirect:/medida/lista";
	}
	
}
