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

import com.ventura.app.estado.Estado;
import com.ventura.app.model.Negocio;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class NegocioRepositoryTest {

	@Autowired	
	private NegocioRepository negocioRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test()
	public void testGuardarNegocio() {
		
		Negocio negocio=getNegocio();
		Negocio guardarInDb=testEntityManager.persist(negocio);
		
		Negocio getFromDb=negocioRepository.findById(guardarInDb.getNid()).get();
		assertThat(getFromDb).isEqualTo(guardarInDb);
	}
	
	
	
	private Negocio getNegocio() {
		
		Negocio negocio=new Negocio();
		Estado estado=null;
		negocio.setNombre("Avicola Ventura");
		negocio.setEstado(estado.ACTIVO);
		return negocio;
	}
}
