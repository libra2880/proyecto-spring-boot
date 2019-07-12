package com.ventura.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Departamento;
import com.ventura.app.model.Provincia;
import com.ventura.app.repository.DepartamentoRepository;
import com.ventura.app.repository.ProvinciaRepository;
import com.ventura.app.service.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{

	private DepartamentoRepository departamentoRepository;
	private ProvinciaRepository provinciaRepository;
	
	
	@Autowired
	public ProvinciaServiceImpl(DepartamentoRepository departamentoRepository,
			ProvinciaRepository provinciaRepository) {
		
		this.departamentoRepository = departamentoRepository;
		this.provinciaRepository = provinciaRepository;
	}

	@Override
	public List<Provincia> provinciaLista() {
		// TODO Auto-generated method stub
		return provinciaRepository.findAll();
	}

	@Override
	public Optional<Provincia> getProvincia(Long idprovincia) {
	
		return provinciaRepository.findById(idprovincia);
	}

	@Override
	public Provincia agregarProvincia(Provincia provincia) {
		provincia.setDepartamento(departamentoRepository.getOne(provincia.getDepartamento().getIddepartamento()));
		return provinciaRepository.save(provincia);
	}

	@Override
	public String eliminarProvincia(Long idprovincia) {
		provinciaRepository.deleteById(idprovincia);
		return "{'mensaje':'Provincia Eliminado'}";
	}

	@Override
	public String actualizarProvincia(Long idprovincia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provincia> findByDepartamento(Departamento departamento) {
		
		return provinciaRepository.findByDepartamento(departamento);
	}

}
