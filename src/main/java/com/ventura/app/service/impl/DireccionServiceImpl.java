package com.ventura.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Direccion;
import com.ventura.app.repository.DireccionRepository;
import com.ventura.app.repository.UsuarioRepository;
import com.ventura.app.service.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

	private DireccionRepository direccionRepository;
	private UsuarioRepository usuarioRepository;	
		
	@Autowired
	public DireccionServiceImpl(DireccionRepository direccionRepository,UsuarioRepository usuarioRepository) {
		
		this.direccionRepository = direccionRepository;
		this.usuarioRepository=usuarioRepository;
	}

	@Override
	public List<Direccion> direccionLista() {
		// TODO Auto-generated method stub
		return direccionRepository.findAll();
	}

	@Override
	public Optional<Direccion> getDireccion(Long id) {
		// TODO Auto-generated method stub
		return direccionRepository.findById(id);
	}

	@Override
	public Direccion agregarDireccion(Direccion direccion) {
	
		direccion.setUsuario(usuarioRepository.getOne(direccion.getUsuario().getId()));
		return direccionRepository.save(direccion);
	}

	@Override
	public String eliminarDireccion(Long id) {
		direccionRepository.deleteById(id);
		return "{'Mensaje':'Direccion Eliminado'}";
	}

	@Override
	public String actualizarDireccion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}





}
