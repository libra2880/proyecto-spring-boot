package com.ventura.app.model;

import java.io.Serializable;
import java.util.HashSet;
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
public class Pais implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	

	public Pais(Long idpais, String nompais, Set<Departamento> departamento) {
		
		this.idpais = idpais;
		this.nompais = nompais;
		this.departamento = departamento;
	}
	
	

	public Pais() {
		
		// TODO Auto-generated constructor stub
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idpais", updatable = false, nullable = false,unique=true)
	private Long idpais;
	
	
	@Column(name="nompais",nullable=false,length=40)
	private String nompais;
	
	
	@OneToMany(targetEntity=Departamento.class,mappedBy="pais",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Departamento> departamento;

	public Long getIdpais() {
		return idpais;
	}

	public void setIdpais(Long idpais) {
		this.idpais = idpais;
	}

	public String getNompais() {
		return nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

	
	
	
	
	
	
	
}
