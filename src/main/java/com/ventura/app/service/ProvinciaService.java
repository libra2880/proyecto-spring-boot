package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Departamento;
import com.ventura.app.model.Provincia;

public interface ProvinciaService {

	List<Provincia> provinciaLista();
	Optional<Provincia> getProvincia(Long idprovincia);
	Provincia agregarProvincia(Provincia provincia);
	String eliminarProvincia(Long idprovincia);
	String actualizarProvincia(Long idprovincia);
	List<Provincia> findByDepartamento(Departamento departamento);
}
