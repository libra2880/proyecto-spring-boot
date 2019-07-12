package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Rol;
import com.ventura.app.model.Usuario;

public interface UsuarioService {

	List<Usuario> usuarioLista();
	Optional <Usuario> getUsuario(Long id);
	Usuario agregarUsuario(Usuario usuario);
	String eliminarUsuario(Long id);
	List<Rol> listaRol();
	
	
	String actualizarUsuario(Long id);
	
}
