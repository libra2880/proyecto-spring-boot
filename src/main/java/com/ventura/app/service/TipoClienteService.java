package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.TipoCliente;

public interface TipoClienteService {

	List<TipoCliente> tClienteLista();
	Optional<TipoCliente> getTCliente(Long idTipoCliente);
	TipoCliente agregarTCliente(TipoCliente tCliente);
	String eliminarTCliente(Long idtipocliente);
	String actualizarTCliente(Long idtipocliente);
	
	
}
