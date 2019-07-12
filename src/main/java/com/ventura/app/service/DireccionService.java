package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Direccion;



public interface DireccionService {

	List<Direccion> direccionLista();
	Optional <Direccion> getDireccion(Long id);
	Direccion agregarDireccion(Direccion direccion);
	String eliminarDireccion(Long id);	
	String actualizarDireccion(Long id);
	
}
