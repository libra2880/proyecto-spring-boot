package com.ventura.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ventura.app.model.TipoEmpleado;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TipoEmpleadoRepositoryTest {

	@Autowired
	private TipoEmpleadoRepository tipoEmpleadoRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test()
	public void testGuardarTipoEmpleado() {
		
		TipoEmpleado tipoEmpleado=getTipoEmpleado();
		TipoEmpleado guardarInDb=testEntityManager.persist(tipoEmpleado);
		
		TipoEmpleado getFromDb=tipoEmpleadoRepository.findById(guardarInDb.getIdtipoempleado()).get();
		assertThat(getFromDb).isEqualTo(guardarInDb);
		
		
	}
	
	
	private TipoEmpleado getTipoEmpleado() {
		
		TipoEmpleado tipoEmpleado=new TipoEmpleado();
		tipoEmpleado.setNombre("Ingeniero de Sistemas");
		tipoEmpleado.setDescripcion("Ingeniero de Sistemas");
		
		return tipoEmpleado;
	}
	
}
