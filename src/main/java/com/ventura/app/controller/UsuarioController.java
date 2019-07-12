package com.ventura.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventura.app.model.Usuario;
import com.ventura.app.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class UsuarioController {

	
	
	private UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
	
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/form")
	public String usuarioForm(Model model){
		model.addAttribute("usuarioForm",new Usuario());
		model.addAttribute("roles",usuarioService.listaRol());
		return "usuario/form";
	}
	
	@GetMapping("/actualizar/{id}")
	public String actualizarUsuario(@PathVariable Long id,Model model){
		model.addAttribute("usuarioForm",usuarioService.getUsuario(id));
		model.addAttribute("roles",usuarioService.listaRol());
		return "redirect:/usuario/lista";
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
	
	@GetMapping("/lista")
	@PreAuthorize("hasRole('admin') or hasRole('user')")
	public String usuarioLista(Model model ){
		model.addAttribute("usuarios",usuarioService.usuarioLista());
		model.addAttribute("roles",usuarioService.listaRol());
		return "/usuario/lista";
		
	}
	@RequestMapping("/lista/{id}")
	@PreAuthorize("hasRole('admin') or hasRole('user')")
	public Optional<Usuario> getUsuario(@PathVariable Long id){
		return usuarioService.getUsuario(id);
		
	}
	@PostMapping("/agregar")
	@PreAuthorize("hasRole('admin')")
	public String agregarUsuario(@ModelAttribute Usuario usuario,Model model) {
		
		String mensaje="";
		if(usuario.getId()==null){
			mensaje="agregado";
		}else{
			mensaje="actualizado";
		}
		
		model.addAttribute("mensaje",usuarioService.agregarUsuario(usuario).getUsuarioNombre()+"agregado...");
		return "redirect:/usuario/lista";
			
	}
	
	@GetMapping("/eliminar/{id}")
	@PreAuthorize("hasRole('admin')")
	public String eliminarUsuario(@PathVariable Long id,Model model){
		model.addAttribute("mensaje",usuarioService.eliminarUsuario(id));
		return "redirect:/usuario/lista";
		
	}
	
	
	
}
