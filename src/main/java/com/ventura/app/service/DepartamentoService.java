package com.ventura.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.ventura.app.model.Departamento;
import com.ventura.app.model.Pais;

public interface DepartamentoService {

	List<Departamento> departamentoLista();
	Optional<Departamento> getDepartamento(Long iddepartamento);
	Departamento agregarDepartamento(Departamento departamento);
	String eliminarDepartamento(Long iddepartamento);
	String actualizarDepartamento(Long iddepartamento);
	
	
	List<Departamento> findByPais(Long idPais);
	List<Departamento> findforPais(Pais idPais);
	
	Set<Departamento> findByPais1(Long idPais);
	
	List<Departamento> departamentoLista(Pais idPais);
	
	Object findforPais(Departamento idPais);
	
	Set<Departamento> findPaisForDepartamento(Long idPais);
	
	

}
