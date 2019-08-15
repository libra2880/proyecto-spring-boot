package com.ventura.app.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ventura.app.model.Pais;

import com.ventura.app.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{

	private PaisRepository paisRepository;
	
	
	
	@Autowired
	public PaisServiceImpl(PaisRepository paisRepository) {
		
		this.paisRepository = paisRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pais> paisLista() {
		
		return paisRepository.findAll();
	}



	@Override
	public String eliminarPais(Long idpais) {
		
		return null;
	}

	@Override
	public String actualizarPais(Long idpais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pais> getPais(Long idpais) {
		// TODO Auto-generated method stub
		return paisRepository.findById(idpais);
	}

	@Override
	@Transactional
	public Pais agregarPais(Pais pais) {
		// TODO Auto-generated method stub
		return paisRepository.save(pais);
	}

	@Override
	@Transactional(readOnly=true)
	public Pais find(Long idPais) {
		
		return paisRepository.findById(idPais).orElse(null);
	}

	
}
