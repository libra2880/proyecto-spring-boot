package com.ventura.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Genero;
import com.ventura.app.repository.GeneroRepository;
import com.ventura.app.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{

	
	private GeneroRepository generoRepository;
	
	
	
	@Autowired
	public GeneroServiceImpl(GeneroRepository generoRepository) {
		
		this.generoRepository = generoRepository;
	}

	@Override
	public List<Genero> generoLista() {
		
		return generoRepository.findAll();
	}

	@Override
	public Optional<Genero> getGenero(Long idgenero) {
		
		return generoRepository.findById(idgenero);
	}

	@Override
	public Genero agregarGenero(Genero genero) {
		
		return generoRepository.save(genero);
	}

	@Override
	public String eliminarGenero(Long idgenero) {
		
		generoRepository.deleteById(idgenero);
		return "{'Mensaje':'Genero eliminado'}";
	}

	@Override
	public String actualizarGenero(Long idgenero) {
		
		return null;
	}

	
}
