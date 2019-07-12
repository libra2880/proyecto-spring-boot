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

import com.ventura.app.model.TipoComprobante;
import com.ventura.app.service.TipoComprobanteService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class TipoComprobanteController {

	private TipoComprobanteService tComprobanteS;

	@Autowired
	public TipoComprobanteController(TipoComprobanteService tComprobanteS) {
		
		this.tComprobanteS = tComprobanteS;
	}
	
	@GetMapping("/tipocomprobante")
	public String tComprobanteLista(Model model) {
		model.addAttribute("tcomprobantes",tComprobanteS.lTComprobante());
		return"mantenimiento/tipocomprobante";
	}
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping("/agregartcomprobante")
	public String agregarTComprobante(Model model,@ModelAttribute("tcomprobantes") TipoComprobante tcomprobante) {
		model.addAttribute("tcomprobantes",tComprobanteS.agregarTComprobante(tcomprobante));
		
		return "redirect:/mantenimiento/tipocomprobante";
		
	}
}
