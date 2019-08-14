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
public class Provincia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idprovincia", updatable = false, nullable = false,unique=true)
	private Long idprovincia;
	
	@Column(name = "nomprovincia", nullable = false, length = 40)
	private String nomprovincia;
	
	@OneToMany(targetEntity=Distrito.class,mappedBy="provincia",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Distrito> distrito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iddepartamento")
	private Departamento departamento;

	public Long getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(Long idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getNomprovincia() {
		return nomprovincia;
	}

	public void setNomprovincia(String nomprovincia) {
		this.nomprovincia = nomprovincia;
	}

	public Set<Distrito> getDistrito() {
		return distrito;
	}

	public void setDistrito(Set<Distrito> distrito) {
		this.distrito = distrito;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}
