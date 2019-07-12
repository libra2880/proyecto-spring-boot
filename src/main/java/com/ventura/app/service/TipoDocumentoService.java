package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.TipoDocumento;

public interface TipoDocumentoService {

	List<TipoDocumento> tDocumentoLista();
	Optional<TipoDocumento> getTDocumento(Long idtipodocumento);
	TipoDocumento agregarTDocumento(TipoDocumento tDocumento);
	String eliminarTDocumento(Long idtipodocuemnto);
	String actualizarTDocumento(Long idtipodocumento);
}
