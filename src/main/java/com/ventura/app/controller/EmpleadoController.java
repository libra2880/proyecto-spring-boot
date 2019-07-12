package com.ventura.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ventura.app.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class EmpleadoController {

	private EmpleadoService empleadoService;
	
	
	@Autowired
	public EmpleadoController(EmpleadoService empleadoService) {
		
		this.empleadoService = empleadoService;
	}



	@GetMapping("/login")
	public String login(Model model,String error,String logout){
		
		if(error!=null){
			model.addAttribute("error","Nombre usuario y clave es invalido");
		}
		if(logout!=null){
			
			model.addAttribute("mensaje", "Ha cerrado sesión exitosamente");
		}
		
		
		return "login";
	}
}
