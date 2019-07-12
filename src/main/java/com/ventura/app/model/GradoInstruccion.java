package com.ventura.app.model;

import java.io.Serializable;
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
public class GradoInstruccion implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idgradoins", updatable = false, nullable = false,unique=true)
	private Long idgradoins;
	
	@Column(name="nombre",nullable=false,length=50)
	private String nombre;
	
	
	@OneToMany(targetEntity=Empleado.class,mappedBy="gradoinstruccion",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Empleado> empleado;

	public Long getIdgradoins() {
		return idgradoins;
	}

	public void setIdgradoins(Long idgradoins) {
		this.idgradoins = idgradoins;
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
