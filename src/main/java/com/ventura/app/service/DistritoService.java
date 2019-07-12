package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Distrito;

public interface DistritoService {

	List<Distrito> distritoLista();
	Optional<Distrito>getDistrito(Long id);
	Distrito agregarDistrito(Distrito distrito);
	String eliminarDistrito(Long id);
	String actualizarDistrito(Long id);
}
