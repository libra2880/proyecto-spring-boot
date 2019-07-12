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

import com.ventura.app.model.Cliente;
import com.ventura.app.service.ClienteService;
import com.ventura.app.service.TipoClienteService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class ClienteController {

	private ClienteService clienteService;
	
	private TipoClienteService tipoClienteService;

	@Autowired
	public ClienteController(ClienteService clienteService, TipoClienteService tipoClienteService) {
		
		this.clienteService = clienteService;
		this.tipoClienteService = tipoClienteService;
	}
	
	@GetMapping("/cliente")
	public String clienteLista(Model model) {
		model.addAttribute("clientes",clienteService.listaCliente());
		model.addAttribute("tipoclientes",tipoClienteService.tClienteLista());
		return "mantenimiento/cliente";
	}
	@PostMapping("/agregarcliente")
	@PreAuthorize("hasRole('admin')")
	public String agregarCliente(@ModelAttribute ("clientes") Cliente cliente,Model model) {
		
		model.addAttribute("clientes",clienteService.agregarCliente(cliente));
		
		return "redirect:/mantenimiento/cliente";
		
	}
	
	
	
	
}
