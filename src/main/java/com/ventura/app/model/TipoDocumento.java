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
public class TipoDocumento implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idtipodocu", updatable = false, nullable = false,unique=true)
	private Long idtipodocu;
	
	@Column(name="descripcionlarga",nullable=false,length=40)
	private String descripcionlarga;
	
	@Column(name="descripcioncorta",nullable=false,length=40)
	private String descripcioncorta;
	
	@OneToMany(targetEntity=Empleado.class,mappedBy="tipodocumento",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Empleado> empleado;

	public Long getIdtipodocu() {
		return idtipodocu;
	}

	public void setIdtipodocu(Long idtipodocu) {
		this.idtipodocu = idtipodocu;
	}

	public String getDescripcionlarga() {
		return descripcionlarga;
	}

	public void setDescripcionlarga(String descripcionlarga) {
		this.descripcionlarga = descripcionlarga;
	}

	public String getDescripcioncorta() {
		return descripcioncorta;
	}

	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}

	public Set<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Set<Empleado> empleado) {
		this.empleado = empleado;
	}
	
	
	
}
