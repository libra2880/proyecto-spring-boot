package com.ventura.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genero {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idgenero", updatable = false, nullable = false,unique=true)
	private Long idgenero;
	
	
	@Column(name="nombre",nullable=false,length=40)
	private String nombre;
	
	@OneToMany(targetEntity=Empleado.class,mappedBy="genero",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Empleado> empleado;

	public Long getIdgenero() {
		return idgenero;
	}

	public void setIdgenero(Long idgenero) {
		this.idgenero = idgenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Set<Empleado> empleado) {
		this.empleado = empleado;
	}
	
	
	
}
