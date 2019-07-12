package com.ventura.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.ventura.app.model.Departamento;
import com.ventura.app.model.Pais;


public interface DepartamentoRepository extends JpaRepository<Departamento,Long>{

	
	@Query("SELECT d.iddepartamento as iddepartamento, d.nomdepartamento as nomdepartamento FROM Departamento d where pais.idpais = :idPais")
	List<Departamento> findByPais(@Param("idPais") Long idPais);

	@Query("SELECT d.iddepartamento as iddepartamento, d.nomdepartamento as nomdepartamento FROM Departamento d where pais.idpais = :idPais")
	List<Departamento> findforPais(@Param("idPais") List<Pais> idPais);
	
	
	
	@Query("SELECT d.iddepartamento as iddepartamento, d.nomdepartamento as nomdepartamento FROM Departamento d where pais.idpais = :idPais")
	Set<Departamento> findByPais1(@Param("idPais") Long idPais);

	@Query("SELECT d.iddepartamento as iddepartamento, d.nomdepartamento as nomdepartamento FROM Departamento d where pais.idpais = :idPais")
	List<Departamento> findAll(@Param("idPais") Pais idPais);

	@Query("SELECT d.iddepartamento as iddepartamento, d.nomdepartamento as nomdepartamento FROM Departamento d where pais.idpais = :idPais")
	Object findforPais(Departamento idPais);
	
	@Query("SELECT d.iddepartamento as iddepartamento, d.nomdepartamento as nomdepartamento FROM Departamento d where pais.idpais = :idPais")
	Set<Departamento> findPaisForDepartamento(Long idPais);

	
}
