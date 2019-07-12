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

import com.ventura.app.model.Negocio;
import com.ventura.app.model.Tienda;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TiendaRepositoryTest {
	
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test()
	public void testGuardarTienda() {
		
		Tienda tienda=getTienda();
		Tienda guardarInDb=testEntityManager.persist(tienda);
		Tienda getFromDb=tiendaRepository.findById(guardarInDb.getTid()).get();
		
		assertThat(getFromDb).isEqualTo(guardarInDb);
	}
	
	
	private Tienda getTienda() {
		Tienda tienda=new Tienda();
		Negocio negocio=new Negocio();
		tienda.setNomTienda("Villa Sur");
		tienda.setDireccion("E 198 Plaza Villa Sur");
		negocio.setNid((long) 1);
		tienda.setNegocio(negocio);
		return tienda;
	    
	}
	
	
	
}
