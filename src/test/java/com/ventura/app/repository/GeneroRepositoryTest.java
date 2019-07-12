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

import com.ventura.app.model.Genero;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class GeneroRepositoryTest {

	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void testGuardarGenero() {
		
		Genero genero=getGenero();
		Genero guardarInDb=testEntityManager.persist(genero);
		
		Genero getFromDb=generoRepository.findById(guardarInDb.getIdgenero()).get();
		assertThat(getFromDb).isEqualTo(guardarInDb);
	}
	
	private Genero getGenero() {
		
		Genero genero=new Genero();
		genero.setNombre("Masculino");
		return genero;
	}
}
