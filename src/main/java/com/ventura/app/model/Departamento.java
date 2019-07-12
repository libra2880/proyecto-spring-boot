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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departamento implements Serializable {
	
	


	private static final long serialVersionUID = 1L;
	
	
	

	public Departamento() {
		
	}

	public Departamento(Long iddepartamento, String nomdepartamento, Set<Provincia> provincia, Pais pais) {
		
		this.iddepartamento = iddepartamento;
		this.nomdepartamento = nomdepartamento;
		this.provincia = provincia;
		this.pais = pais;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iddepartamento", updatable = false, nullable = false,unique=true)
	private Long iddepartamento;
	
	@Column(name="nomdepartamento",nullable=false,length=40)
	private String nomdepartamento;
	
	@OneToMany(targetEntity=Provincia.class,mappedBy="departamento",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Provincia> provincia;
	
	@ManyToOne
	@JoinColumn(name="idpais")
	@JsonIgnore
	private Pais pais;
	

	public Long getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(Long iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNomdepartamento() {
		return nomdepartamento;
	}

	public void setNomdepartamento(String nomdepartamento) {
		this.nomdepartamento = nomdepartamento;
	}

	public Set<Provincia> getProvincia() {
		return provincia;
	}

	public void setProvincia(Set<Provincia> provincia) {
		this.provincia = provincia;
	}

	@JsonIgnore
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
	

}
