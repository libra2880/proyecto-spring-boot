package com.ventura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ventura.app.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{
  
	@Query("From Grupo WHERE nombre=:nombre")
	Grupo findByGrupoNombre(@Param("nombre")String nombre);
}
