package com.ventura.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tienda {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "tid", updatable = false, nullable = false)
	private Long tid;
	
	 
	 @Column(name = "nomTienda", nullable = false, length = 40)
	 private String nomTienda;
	 
	 @Column(name="direccion",nullable=false,length=60)
	 private String direccion;
	 
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="nid")
	private Negocio negocio;
	
	
	@OneToMany(targetEntity=Empleado.class,mappedBy="tienda",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Empleado> empleado;


	public Long getTid() {
		return tid;
	}


	public void setTid(Long tid) {
		this.tid = tid;
	}


	public Negocio getNegocio() {
		return negocio;
	}


	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}


	public String getNomTienda() {
		return nomTienda;
	}


	public void setNomTienda(String nomTienda) {
		this.nomTienda = nomTienda;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Set<Empleado> getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Set<Empleado> empleado) {
		this.empleado = empleado;
	}

	

	
	
	
	 
	 
	 
	 
	 
}
