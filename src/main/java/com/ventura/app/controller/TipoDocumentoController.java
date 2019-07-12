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
import com.ventura.app.model.TipoDocumento;
import com.ventura.app.service.TipoDocumentoService;

@RequestMapping("/mantenimiento")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class TipoDocumentoController {

	private TipoDocumentoService tDocumentoService;

	@Autowired
	public TipoDocumentoController(TipoDocumentoService tDocumentoService) {
		
		this.tDocumentoService = tDocumentoService;
	}
	
	@GetMapping("/tipodocumento")	
	public String tipoDocumentoLista(Model model) {
		
		model.addAttribute("tipodocumentos",tDocumentoService.tDocumentoLista());
		return "mantenimiento/tipodocumento";
	}
	
	@PostMapping("/agregartipodocumento")
	@PreAuthorize("hasRole('admin')")
	public String agregarTCliente(@ModelAttribute("tipodocumentos") TipoDocumento tDocumento,Model model) throws IOException
	{
		model.addAttribute("tipodocumentos",tDocumentoService.agregarTDocumento(tDocumento));
		return "redirect:/mantenimiento/tipodocumento";
		
	}
}
