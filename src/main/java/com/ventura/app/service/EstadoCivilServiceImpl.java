package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.EstadoCivil;
import com.ventura.app.repository.EstadoCivilRepository;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService{
	
	
	private EstadoCivilRepository estadoCivilRepository;
	
	
	
	@Autowired
	public EstadoCivilServiceImpl(EstadoCivilRepository estadoCivilRepository) {
	
		this.estadoCivilRepository = estadoCivilRepository;
	}

	
	@Override
	public List<EstadoCivil> estadoCivilLista() {
		
		return estadoCivilRepository.findAll();
	}

	@Override
	public Optional<EstadoCivil> getEstadoCivil(Long idestadocivil) {
		
		return estadoCivilRepository.findById(idestadocivil);
	}

	@Override
	public EstadoCivil agregarECivil(EstadoCivil estadocivil) {
		
		return estadoCivilRepository.save(estadocivil);
	}

	@Override
	public String eliminarECivil(Long idestadocivil) {
		estadoCivilRepository.deleteById(idestadocivil);
		return "{'Mensaje':'Tipo de estado civil eliminado'}";
	}

	@Override
	public String actualizarECivil(Long idestadocivil) {
		// TODO Auto-generated method stub
		return null;
	}

}
