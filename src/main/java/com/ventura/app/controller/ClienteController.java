package com.ventura.app.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ventura.app.model.Cliente;
import com.ventura.app.service.ClienteService;
import com.ventura.app.service.DepartamentoService;
import com.ventura.app.service.DistritoService;
import com.ventura.app.service.PaisService;
import com.ventura.app.service.ProvinciaService;
import com.ventura.app.service.TipoClienteService;

@RequestMapping("/venta")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class ClienteController {

	private ClienteService clienteService;
	
	private TipoClienteService tipoClienteService;
	
	
	private PaisService paisService;
	private DepartamentoService departamentoService;
	private ProvinciaService provinciaService;
	private DistritoService distritoService;

	@Autowired
	public ClienteController(ClienteService clienteService, TipoClienteService tipoClienteService,
			PaisService paisService, DepartamentoService departamentoService, ProvinciaService provinciaService,
			DistritoService distritoService) {
		
		this.clienteService = clienteService;
		this.tipoClienteService = tipoClienteService;
		this.paisService = paisService;
		this.departamentoService = departamentoService;
		this.provinciaService = provinciaService;
		this.distritoService = distritoService;
	}
	
	@GetMapping("/cliente")
	public String clienteLista(Model model) {
		model.addAttribute("clientes",clienteService.listaCliente());
		model.addAttribute("tipoclientes",tipoClienteService.tClienteLista());
		model.addAttribute("paises",paisService.paisLista());
		return "venta/cliente";
	}
	
	@PostMapping("/agregarcliente")
	@PreAuthorize("hasRole('admin')")
	public String agregarCliente(@ModelAttribute ("clientes") Cliente cliente,Model model) {
		
		model.addAttribute("clientes",clienteService.agregarCliente(cliente));
		
		return "redirect:/venta/cliente";
		
	}
	
	@RequestMapping(value="cargarPais/{idpais}",method = RequestMethod.GET)
	@ResponseBody
	public String cargarPais(@PathVariable("idpais") Long idpais) {
		Gson gson=new Gson();
		return gson.toJson(departamentoService.findByPais(idpais));
	}
	
	
}
