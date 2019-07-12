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

import com.ventura.app.model.Grupo;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class GrupoRepositoryTest {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test()
	public void testGuardarGrupo() {
		
		Grupo grupo=getGrupo();
		Grupo guardarInDb=testEntityManager.persist(grupo);
		
		Grupo getFromDb= grupoRepository.findById(guardarInDb.getIdgrupo()).get();
		assertThat(getFromDb).isEqualTo(guardarInDb);
	}
	
	private Grupo getGrupo() {
		
		Grupo grupo=new Grupo();
		grupo.setNombre("admin");
		grupo.setDescripcion("tiene el mayor privilegio");
		
		return grupo;
	}
	
	
	
	
}
