package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Distrito;

import com.ventura.app.repository.DistritoRepository;
import com.ventura.app.repository.ProvinciaRepository;

@Service
public class DistritoServiceImpl  implements DistritoService{
	
	private ProvinciaRepository provinciaRepository;
	private DistritoRepository distritoRepository;
	
	
	
	
	@Autowired
	public DistritoServiceImpl(ProvinciaRepository provinciaRepository, DistritoRepository distritoRepository) {
		
		this.provinciaRepository = provinciaRepository;
		this.distritoRepository = distritoRepository;
	}

	@Override
	public List<Distrito> distritoLista() {
		
		return distritoRepository.findAll();
	}

	@Override
	public Optional<Distrito> getDistrito(Long id) {
		
		return distritoRepository.findById(id);
	}

	@Override
	public Distrito agregarDistrito(Distrito distrito) {
		
		distrito.setProvincia(provinciaRepository.getOne(distrito.getProvincia().getIdprovincia()));
		return distritoRepository.save(distrito);
	}

	@Override
	public String eliminarDistrito(Long id) {
		distritoRepository.deleteById(id);
		return "{'mensaje':'Distrito Eliminado'}";
	}

	@Override
	public String actualizarDistrito(Long id) {

		return null;
	}

}
