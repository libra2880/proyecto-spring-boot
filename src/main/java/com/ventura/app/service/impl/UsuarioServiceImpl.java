package com.ventura.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Rol;
import com.ventura.app.model.Usuario;
import com.ventura.app.repository.RolRepository;
import com.ventura.app.repository.UsuarioRepository;
import com.ventura.app.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	private RolRepository rolRepository;
	
	
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository,RolRepository rolRepository) {
	
		this.usuarioRepository = usuarioRepository;
		this.rolRepository=rolRepository;
	}




	@Override
	public List<Usuario> usuarioLista() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}




	@Override
	public Optional<Usuario> getUsuario(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}




	@Override
	public Usuario agregarUsuario(Usuario usuario) {
		
		usuario.setClave(new BCryptPasswordEncoder().encode(usuario.getClave()));
		usuario.setRol(rolRepository.getOne(usuario.getRol().getId()));
		return usuarioRepository.save(usuario);
	}




	@Override
	public String eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
		return "{'mensaje':'Usuario borrado'}";
	}




	@Override
	public String actualizarUsuario(Long id) {
	
		return "{'mensaje':'Usuario actualizado'}";
	}




	@Override
	public List<Rol> listaRol() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}






}
