package com.ventura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ventura.app.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

	@Query("Select  f from Factura f order by codigo Desc")
	Factura obtenerUltimoRegistro();
	
	
	@Query("Select  Count(*) from Factura ")
	Long obtenerTotalRegistrosFactura();
	
	@Query("Select  f from Factura f where numfact=:numfact")
	Factura findFacturabyNumero(Long numfact);
	
	@Query("Select  f from Factura f where codigo=:codigo")
	Factura findFacuraByCodigo(Long codigo);
	
}
