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
public class TipoComprobante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idtipocomprobante", updatable = false, nullable = false,unique=true)
	private Long idtipocomprobante;
	
	@Column(name="descripcion",nullable=false,length=40)
	private String descripcion;
	
	@Column(name="abrev",nullable=false,length=4)
	private String abrev;
	
	@OneToMany(targetEntity=Comprobante.class,mappedBy="tipocomprobante",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Comprobante>comprobante;
	
	

	
	public Long getIdtipocomprobante() {
		return idtipocomprobante;
	}

	public void setIdtipocomprobante(Long idtipocomprobante) {
		this.idtipocomprobante = idtipocomprobante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbrev() {
		return abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	public Set<Comprobante> getComprobante() {
		return comprobante;
	}

	public void setComprobante(Set<Comprobante> comprobante) {
		this.comprobante = comprobante;
	}
	
	
	
	
}
