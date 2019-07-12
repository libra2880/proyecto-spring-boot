package com.ventura.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.app.model.Factura;
import com.ventura.app.repository.FacturaRepository;
import com.ventura.app.service.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService {

	private FacturaRepository facturaRepository;
	
	
	@Autowired
	public FacturaServiceImpl(FacturaRepository facturaRepository) {
	
		this.facturaRepository = facturaRepository;
	}

	@Override
	public Factura obtenerUltimoRegistro() {
		
		return facturaRepository.obtenerUltimoRegistro();
	}

	@Override
	public Long obtenerTotalRegistrosFactura() {
		
		
		return facturaRepository.obtenerTotalRegistrosFactura();
	}

	@Override
	public List<Factura> facturaLista() {
		// TODO Auto-generated method stub
		return facturaRepository.findAll();
	}

	@Override
	public Long nextNro() {
		facturaRepository.findAll();
		return (long) (facturaLista().size()+1);
	}

	@Override
	public Factura findFacturabyNumero(Long numfact) {
		// TODO Auto-generated method stub
		return facturaRepository.findFacturabyNumero(numfact);
	}

	@Override
	public Factura findFacturaByCodigo(Long codigo) {
		// TODO Auto-generated method stub
		return findFacturaByCodigo(codigo);
	}

}
