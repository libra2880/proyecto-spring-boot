package com.ventura.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ventura.app.model.Medida;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class MedidaRepositoryTest {

	@Autowired
	private MedidaRepository medidaRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test()
	public void testGuardarMedida() {	
		
		Medida medida=getMedida();
		Medida guardarInDb=testEntityManager.persist(medida);
		
		Medida getFromDb=medidaRepository.findById(guardarInDb.getId()).get();
		assertThat(getFromDb).isEqualTo(guardarInDb);
	
	}
	
	private Medida getMedida() {
		
		Medida medida=new Medida();
		
		medida.setDescripcion("Gramo");
		return medida;
	}
}
