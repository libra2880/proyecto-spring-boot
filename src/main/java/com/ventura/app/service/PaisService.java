package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Pais;

public interface PaisService {

	List<Pais> paisLista();
	Optional<Pais> getPais(Long idpais);
	Pais agregarPais(Pais pais);
	String eliminarPais(Long idpais);
	String actualizarPais(Long idpais);
	Pais find(Long idPais);
}
