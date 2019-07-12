package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.TipoComprobante;

public interface TipoComprobanteService {

	List<TipoComprobante> lTComprobante();
	Optional<TipoComprobante>getTComprobante(Long idTComprobante);
	TipoComprobante agregarTComprobante(TipoComprobante tComprobante);
	String eliminarTComprobante(Long idTComprobante);
	String actualizarTComprobante(Long idTComprobante);
}
