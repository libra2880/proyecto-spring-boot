package com.ventura.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.TipoCliente;
import com.ventura.app.repository.TipoClienteRepository;
import com.ventura.app.service.TipoClienteService;

@Service
public class TipoClienteServiceImpl implements TipoClienteService{

	private TipoClienteRepository tipoClienteRepository;
	
	@Autowired
	public TipoClienteServiceImpl(TipoClienteRepository tipoClienteRepository) {
	
		this.tipoClienteRepository = tipoClienteRepository;
	}

	@Override
	public List<TipoCliente> tClienteLista() {
		
		return tipoClienteRepository.findAll();
	}

	@Override
	public Optional<TipoCliente> getTCliente(Long idTipoCliente) {
		// TODO Auto-generated method stub
		return tipoClienteRepository.findById(idTipoCliente);
	}

	@Override
	public TipoCliente agregarTCliente(TipoCliente tCliente) {
		// TODO Auto-generated method stub
		return tipoClienteRepository.save(tCliente);
	}

	@Override
	public String eliminarTCliente(Long idtipocliente) {
		tipoClienteRepository.deleteById(idtipocliente);
		return "{'Mensaje':'Tipo de cliente eliminado'}";
	}

	@Override
	public String actualizarTCliente(Long idtipocliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
