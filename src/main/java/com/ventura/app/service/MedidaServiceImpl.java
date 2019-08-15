package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Medida;
import com.ventura.app.repository.MedidaRepository;


@Service
public class MedidaServiceImpl implements MedidaService {

	private MedidaRepository medidaRepository;
	
	
	
	
	@Autowired
	public MedidaServiceImpl(MedidaRepository medidaRepository) {
		
		this.medidaRepository = medidaRepository;
	}

	@Override
	public List<Medida> medidaLista() {
		// TODO Auto-generated method stub
		return medidaRepository.findAll();
	}

	@Override
	public Optional<Medida> getMedida(Long id) {
		// TODO Auto-generated method stub
		return medidaRepository.findById(id);
	}

	@Override
	public Medida agregarMedida(Medida medida) {
		// TODO Auto-generated method stub
		return medidaRepository.save(medida);
	}

	@Override
	public String eliminarMedida(Long id) {
		medidaRepository.deleteById(id);
		return "{'mensaje':'Medida borrado'}";
	}

	@Override
	public String actualizarMedida(Long id) {
		// TODO Auto-generated method stub
		return "{'mensaje':'Medida actualizado'}";
	}

}
