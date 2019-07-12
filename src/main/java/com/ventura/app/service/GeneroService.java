package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Genero;

public interface GeneroService {

	List<Genero> generoLista();
	Optional<Genero> getGenero(Long idgenero);
	Genero agregarGenero(Genero genero);
	String eliminarGenero(Long idgenero);
	String actualizarGenero(Long idgenero);
	
	
	
}
