package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.EstadoCivil;

public interface EstadoCivilService {

	List<EstadoCivil> estadoCivilLista();
	Optional<EstadoCivil> getEstadoCivil(Long idestadocivil);
	EstadoCivil agregarECivil(EstadoCivil estadocivil);
	String eliminarECivil(Long idestadocivil);
	String actualizarECivil(Long idestadocivil);
	
	
}
