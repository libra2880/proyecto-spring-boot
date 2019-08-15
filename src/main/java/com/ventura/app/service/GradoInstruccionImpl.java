package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.GradoInstruccion;
import com.ventura.app.repository.GradoInstruccionRepository;

@Service
public class GradoInstruccionImpl implements GradoInstruccionService{

	private GradoInstruccionRepository gradoInstruccionRepository;
	
	@Autowired
	public GradoInstruccionImpl(GradoInstruccionRepository gradoInstruccionRepository) {
	
		this.gradoInstruccionRepository = gradoInstruccionRepository;
	}

	@Override
	public List<GradoInstruccion> gInstruccionLista() {
		
		return gradoInstruccionRepository.findAll();
	}

	@Override
	public Optional<GradoInstruccion> getGInstruccion(Long idgradoins) {
		
		return gradoInstruccionRepository.findById(idgradoins);
	}

	@Override
	public GradoInstruccion agregarGInstruccion(GradoInstruccion gInstruccion) {
		
		return gradoInstruccionRepository.save(gInstruccion);
	}

	@Override
	public String eliminarGInstruccion(Long idgradoins) {
		gradoInstruccionRepository.deleteById(idgradoins);
		return "{'Mensaje':'Grado de instruccion eliminado'}";
	}

	@Override
	public String actualizarGInstruccion(Long idgradoins) {
		// TODO Auto-generated method stub
		return null;
	}

}
