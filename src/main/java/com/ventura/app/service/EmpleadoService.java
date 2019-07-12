package com.ventura.app.service;

import java.util.List;
import java.util.Optional;

import com.ventura.app.model.Empleado;
import com.ventura.app.model.Grupo;

public interface EmpleadoService {

		List<Empleado> empleadoLista();
		Optional<Empleado> getEmpleado(Long idempleado);
		Empleado agregarEmpleado(Empleado empleado);
		String eliminarEmpleado(Long idempleado);
		List<Grupo>listaGrupo();
		String actualizarEmpleado(Long idempleado);

}
