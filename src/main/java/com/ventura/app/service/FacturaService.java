package com.ventura.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.ventura.app.model.Factura;

public interface FacturaService {

	
	Factura obtenerUltimoRegistro();
	
	
	Long obtenerTotalRegistrosFactura();
	
	List<Factura> facturaLista();
	
	Long nextNro();
	
	Factura findFacturabyNumero(Long numfact);
	
	Factura findFacturaByCodigo(Long codigo);
	
	
}
