package com.ventura.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ventura.app.model.Empleado;
import com.ventura.app.model.EstadoCivil;
import com.ventura.app.model.Genero;
import com.ventura.app.model.NivelEducacion;
import com.ventura.app.model.Tienda;
import com.ventura.app.model.TipoEmpleado;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class EmpleadoRepositoryTest {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	
	@Test()
	public void testGuardarEmpleado() {
		Empleado empleado=getEmpleado();
		Empleado guardarInDb=testEntityManager.persist(empleado);
		
		Empleado getFromDb=empleadoRepository.findById(guardarInDb.getIdempleado()).get();
		assertThat(getFromDb).isEqualTo(guardarInDb);
		
	}
	
	
	private Empleado getEmpleado() {
		
		Empleado empleado=new Empleado();
		EstadoCivil estadoCivil=new EstadoCivil();
		Genero genero=new Genero();
		NivelEducacion nivelEducacion=new NivelEducacion();
		Tienda tienda=new Tienda();
		TipoEmpleado tipoEmpleado=new TipoEmpleado();
		
		empleado.setNombre("Jimmy Jesus");
		empleado.setAppaterno("Ventura");
		empleado.setApmaterno("Murillo");
		empleado.setCelular("954789453");
		empleado.setClave("jimito1980");
		empleado.setDireccion("Villa sur");
		empleado.setFechanac(Date.valueOf("1980-09-28"));
		empleado.setInterior("S/I");
		empleado.setNombrevia("S/N");
		empleado.setNombrezona("S/Z");
		empleado.setNumero("S/N");
		empleado.setReferencia("Av revolucion cruce con la Av Bolivar");
		empleado.setRuc("106765678");
		empleado.setTipovia("S/V");
		empleado.setTipozona("S/Z");
		empleado.setUsuarioNombre("libra2880");
		estadoCivil.setIdestadocivil((long) 1);
		empleado.setEstadocivil(estadoCivil);
		genero.setIdgenero((long) 1);
		empleado.setGenero(genero);
		nivelEducacion.setIdniveleducacion((long) 1);
		empleado.setNiveleducacion(nivelEducacion);
		tienda.setTid((long) 1);
		empleado.setTienda(tienda);
		tipoEmpleado.setIdtipoempleado((long) 2);
		empleado.setTipoempleado(tipoEmpleado);
		
		return empleado;
		
		
	}
	
	
	
}
