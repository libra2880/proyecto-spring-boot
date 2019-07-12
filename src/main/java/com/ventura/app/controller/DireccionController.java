package com.ventura.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ventura.app.model.Direccion;
import com.ventura.app.model.Usuario;
import com.ventura.app.service.DireccionService;
import com.ventura.app.service.UsuarioService;


@RequestMapping("/direccion")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class DireccionController {

	
	private DireccionService direccionService;
	
	private UsuarioService usuarioService;

	@Autowired
	public DireccionController(DireccionService direccionService,UsuarioService usuarioService) {
	
		this.direccionService = direccionService;
		this.usuarioService=usuarioService;
	}
	

	
/*	@RequestMapping("/actualizar/{id}")
	public String actualizarDireccion(@PathVariable Long id,Model model,Direccion direccion){
		model.addAttribute("direccion",direccionService.getDireccion(id));
		model.addAttribute("usuarios",usuarioService.getUsuario(id));
		model.addAttribute("usuarios",usuarioService.usuarioLista());
		System.out.println(""+direccion.getId());
		this.direccionService.agregarDireccion(direccion);
		return "direccion/lista"+direccion.getId();
	}*/
	
	@RequestMapping("/actualizar/{id}")
	public String actualizarDireccion(@PathVariable Long id,Model model,Direccion direccion){
		model.addAttribute("direccion",direccionService.getDireccion(id));
		model.addAttribute("usuarios",usuarioService.getUsuario(id));
		model.addAttribute("usuarios",usuarioService.usuarioLista());
		Optional<Direccion> optdireccion=direccionService.getDireccion(id);
		Direccion c = optdireccion.get();
		if(direccion.getId()!=null)
			c.setId(direccion.getId());
		if(direccion.getCiudad()!=null)
			c.setCiudad(direccion.getCiudad());
			c.setDistrito(direccion.getDistrito());
			c.setUsuario(direccion.getUsuario());
			
		return "direccion/lista";
	}
	
	
	@GetMapping("/lista")
	public String direccionLista(Model model) {
		model.addAttribute("direcciones",direccionService.direccionLista());
		model.addAttribute("usuarios",usuarioService.usuarioLista());
		return "direccion/lista";
		
	}
	

	
	@PostMapping("/agregar")
	@PreAuthorize("hasRole('admin')")
	public String agregarDireccion(@ModelAttribute("direcciones") Direccion direcciones,Model model)throws IOException {
		
		model.addAttribute("direcciones", direccionService.agregarDireccion(direcciones).getUsuario().getUsuarioNombre());
		return "redirect:/direccion/lista";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarDireccion(@PathVariable  Long id,Model model){
		model.addAttribute("mensaje",direccionService.eliminarDireccion(id));
		return "redirect:/direccion/lista";
		
	}	
}
