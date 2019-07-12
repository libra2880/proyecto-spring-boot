package com.ventura.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.TipoDocumento;
import com.ventura.app.repository.TipoDocumentoRepository;
import com.ventura.app.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
	
	
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	
	
	@Autowired
	public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository) {
		
		this.tipoDocumentoRepository = tipoDocumentoRepository;
	}

	@Override
	public List<TipoDocumento> tDocumentoLista() {
		
		return tipoDocumentoRepository.findAll();
	}

	@Override
	public Optional<TipoDocumento> getTDocumento(Long idtipodocumento) {
		
		return tipoDocumentoRepository.findById(idtipodocumento);
	}

	@Override
	public TipoDocumento agregarTDocumento(TipoDocumento tDocumento) {
		
		return tipoDocumentoRepository.save(tDocumento);
	}

	@Override
	public String eliminarTDocumento(Long idtipodocuemnto) {
		tipoDocumentoRepository.deleteById(idtipodocuemnto);
		return "{'Mensaje':'Tipo de documento eliminado'}";
	}

	@Override
	public String actualizarTDocumento(Long idtipodocumento) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
