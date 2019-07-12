package com.ventura.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Grupo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idgrupo", updatable = false, nullable = false,unique=true)
	private Long idgrupo;
	
	@Column(name="nombre",nullable=false,length=40)
	private String nombre;
	
	@Column(name="descripcion",nullable=false,length=140)
	private String descripcion;
	
	/*@ManyToMany(mappedBy="grupo")
	private Set<Empleado> empleado;*/
	
	@OneToMany(targetEntity=EmpleadoGrupo.class,mappedBy="grupo",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<EmpleadoGrupo>empleadogrupo;

	public Long getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(Long idgrupo) {
		this.idgrupo = idgrupo;
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

	public Set<EmpleadoGrupo> getEmpleadogrupo() {
		return empleadogrupo;
	}

	public void setEmpleadogrupo(Set<EmpleadoGrupo> empleadogrupo) {
		this.empleadogrupo = empleadogrupo;
	}
	
	
	
}
