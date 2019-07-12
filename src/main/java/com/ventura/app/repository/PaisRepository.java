package com.ventura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ventura.app.model.Pais;

public interface PaisRepository  extends JpaRepository<Pais,Long>{

	@Query("From Pais where idpais= :idPais")
	Pais find(@Param("idPais")Long idPais);
	
	
	

}
