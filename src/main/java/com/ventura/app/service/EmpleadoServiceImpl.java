package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Empleado;
import com.ventura.app.model.Grupo;
import com.ventura.app.repository.EmpleadoRepository;
import com.ventura.app.repository.GrupoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	private EmpleadoRepository empleadoRepository;
	
	private GrupoRepository grupoRepository;
	
	
	@Autowired
	public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, GrupoRepository grupoRepository) {

		this.empleadoRepository = empleadoRepository;
		this.grupoRepository = grupoRepository;
	}

	@Override
	public List<Empleado> empleadoLista() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public Optional<Empleado> getEmpleado(Long idempleado) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(idempleado);
	}

	@Override
	public Empleado agregarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarEmpleado(Long idempleado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupo> listaGrupo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actualizarEmpleado(Long idempleado) {
		// TODO Auto-generated method stub
		return null;
	}

}
