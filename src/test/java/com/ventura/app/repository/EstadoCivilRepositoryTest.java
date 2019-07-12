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

import com.ventura.app.model.EstadoCivil;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class EstadoCivilRepositoryTest {

	@Autowired
	private EstadoCivilRepository estadoCivilRepository;
	
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	
	@Test()
	public void testGuardarEstadoCivil() {
		
		EstadoCivil estadoCivil=getEstadoCivil();
		EstadoCivil guardarInDb=testEntityManager.persist(estadoCivil);
		
		EstadoCivil getFromDb=estadoCivilRepository.findById(guardarInDb.getIdestadocivil()).get();
		
		assertThat(getFromDb).isEqualTo(guardarInDb);
	}
	
	
	private EstadoCivil getEstadoCivil() {
		
		EstadoCivil estadoCivil=new EstadoCivil();
		estadoCivil.setNombre("Soltero");
		return estadoCivil;
	}
	
	
}
