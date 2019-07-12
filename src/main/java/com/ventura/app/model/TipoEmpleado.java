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
public class TipoEmpleado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idtipoempleado", updatable = false, nullable = false,unique=true)
	private Long idtipoempleado;
	
	@Column(name="nombre",nullable=false,length=40)
	private String nombre;
	
	@Column(name="descripcion",nullable=false,length=40)
	private String descripcion;
	
	@OneToMany(targetEntity=Empleado.class,mappedBy="tipoempleado",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Empleado>empleado;
	

	public Long getIdtipoempleado() {
		return idtipoempleado;
	}

	public void setIdtipoempleado(Long idtipoempleado) {
		this.idtipoempleado = idtipoempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Set<Empleado> empleado) {
		this.empleado = empleado;
	}
	
	
	
	
	
	
	
}
