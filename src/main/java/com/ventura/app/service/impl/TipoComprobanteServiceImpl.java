package com.ventura.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.TipoComprobante;
import com.ventura.app.repository.TipoComprobanteRepository;
import com.ventura.app.service.TipoComprobanteService;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {

	
	private TipoComprobanteRepository tipoComprobanteRepository;
	
	
	
	@Autowired
	public TipoComprobanteServiceImpl(TipoComprobanteRepository tipoComprobanteRepository) {
	
		this.tipoComprobanteRepository = tipoComprobanteRepository;
	}

	@Override
	public List<TipoComprobante> lTComprobante() {
	
		return tipoComprobanteRepository.findAll();
	}

	@Override
	public Optional<TipoComprobante> getTComprobante(Long idTComprobante) {
		
		return tipoComprobanteRepository.findById(idTComprobante);
	}

	@Override
	public TipoComprobante agregarTComprobante(TipoComprobante tComprobante) {
	
		return tipoComprobanteRepository.save(tComprobante);
	}

	@Override
	public String eliminarTComprobante(Long idTComprobante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizarTComprobante(Long idTComprobante) {
		// TODO Auto-generated method stub
		return null;
	}

}
