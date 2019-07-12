package com.ventura.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManagerFactory;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ventura.app.model.Departamento;
import com.ventura.app.model.Pais;
import com.ventura.app.repository.DepartamentoRepository;
import com.ventura.app.repository.PaisRepository;
import com.ventura.app.service.DepartamentoService;

@Service("departamentoService")

public class DepartamentoServiceImpl implements DepartamentoService {

	private PaisRepository paisRepository;
	
	
	private DepartamentoRepository departamentoRepository;
	
	
	
	

	@Autowired
	public DepartamentoServiceImpl(PaisRepository paisRepository, DepartamentoRepository departamentoRepository) {
		
		this.paisRepository = paisRepository;
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public List<Departamento> departamentoLista() {
		
		return departamentoRepository.findAll();
	}

	@Override
	public Optional<Departamento> getDepartamento(Long iddepartamento) {
		
		return departamentoRepository.findById(iddepartamento);
	}

	@Override
	public Departamento agregarDepartamento(Departamento departamento) {
		departamento.setPais(paisRepository.getOne(departamento.getPais().getIdpais()));
		return departamentoRepository.save(departamento);
	}

	@Override
	public String eliminarDepartamento(Long iddepartamento) {
		departamentoRepository.deleteById(iddepartamento);
		return "{'mensaje':'Departamento Eliminado'}";
	}

	@Override
	public String actualizarDepartamento(Long iddepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
//	@Transactional(readOnly=true)
	public List<Departamento> findByPais(Long idPais) {
		
		return departamentoRepository.findByPais(idPais);
	}

	
	@Override
	public Set<Departamento> findByPais1(Long idPais) {
		// TODO Auto-generated method stub
		return departamentoRepository.findByPais1(idPais);
	}

	@Override
	public List<Departamento> departamentoLista(Pais idPais) {
	
		List<Departamento> x=new ArrayList<>();
		x=departamentoRepository.findAll(idPais);
		
		return x;
	}

	@Override
	public Object findforPais(Departamento idPais) {
		
		return departamentoRepository.findforPais(idPais);
	}

	@Override
	public Set<Departamento> findPaisForDepartamento(Long idPais) {
		
	     //Pais pais=this.paisRepository.getOne(idPais);
		
		//Pais pais=this.paisRepository.getOne(idPais);
		return departamentoRepository.findPaisForDepartamento(idPais);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findforPais(Pais idPais) {
		// TODO Auto-generated method stub
		return departamentoRepository.findforPais((List<Pais>) idPais);
	}


	
	
	
}
