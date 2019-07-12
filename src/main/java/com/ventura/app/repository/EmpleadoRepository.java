package com.ventura.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ventura.app.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	@Query("From Empleado WHERE usuarioNombre=:usuarionombre")
	Empleado findByEmpleadoNombre(@Param("usuarionombre") String usuarionombre);
}
