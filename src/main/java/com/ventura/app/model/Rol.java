package com.ventura.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class Rol extends AbstractPersistable<Long>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private  Long id;
	
	private String nombre;
	
	@OneToMany(targetEntity=Usuario.class,mappedBy="rol",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Usuario> usuarios;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
