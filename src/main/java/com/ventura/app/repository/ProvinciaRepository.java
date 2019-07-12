package com.ventura.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ventura.app.model.Departamento;
import com.ventura.app.model.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia,Long>{
	
	@Query("SELECT p.departamento as iddepartamento,p.nomprovincia as nomprovincia FROM Provincia p where p.departamento=:departamento")
	List<Provincia> findByDepartamento(@Param("departamento")Departamento departamento);
	
	@Query("Select  p.idprovincia as idprovincia,p.nomprovincia as nomprovincia from Provincia p where departamento.iddepartamento = :idDepartamento")
	List<Provincia> findDepartamento(@Param("idDepartamento") Long idDepartamento);
	
	
}
