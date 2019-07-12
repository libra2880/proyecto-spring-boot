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

import com.ventura.app.model.NivelEducacion;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class NivelEducacionRepositoryTest {

	@Autowired
	private NivelEducacionRepository nivelEducacionRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test()
	public void testGuardarNivelEducacion() {
		
		NivelEducacion nivelEducacion=getNivelEducacion();
		NivelEducacion guardarInDb=testEntityManager.persist(nivelEducacion);
		
		NivelEducacion getFromDb=nivelEducacionRepository.findById(guardarInDb.getIdniveleducacion()).get();
		
		assertThat(getFromDb).isEqualTo(guardarInDb);
	}
	
	
	private NivelEducacion getNivelEducacion() {
		
		NivelEducacion nivelEducacion=new NivelEducacion();
		nivelEducacion.setNombre("Superior");
		return nivelEducacion;
		
		
	}
}
