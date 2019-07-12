package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.GradoInstruccion;

public interface GradoInstruccionService {

	
	List<GradoInstruccion> gInstruccionLista();
	Optional<GradoInstruccion> getGInstruccion(Long idgradoins);
	GradoInstruccion agregarGInstruccion(GradoInstruccion gInstruccion);
	String eliminarGInstruccion(Long idgradoins);
	String actualizarGInstruccion(Long idgradoins);
}
