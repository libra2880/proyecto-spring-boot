package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Medida;

public interface MedidaService {
	
	List<Medida> medidaLista();
	Optional<Medida> getMedida(Long id);
	Medida agregarMedida(Medida medida);
	String eliminarMedida(Long id);	
	String actualizarMedida(Long id);
}
