package com.ventura.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ventura.app.model.EmpleadoGrupo;

public interface EmpleadoGrupoRepository extends JpaRepository<EmpleadoGrupo, Long>{

	@Query("from EmpleadoGrupo a, Empleado b,Grupo c where b.usuarioNombre=?1 and a.empleado=b.idempleado and a.grupo=c.idgrupo")
	EmpleadoGrupo findByGrupoEmpleado(@Param("usuarionombre") String usuarionombre);
	
	
}
