package com.ventura.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Distrito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iddistrito", updatable = false, nullable = false,unique=true)
	private Long iddistrito;
	
	@Column(name = "nomdistrito", nullable = false, length = 40)
	private String nomdistrito;
	
	@ManyToOne
	@JoinColumn(name="idprovincia")
	private Provincia provincia;

	public Long getIddistrito() {
		return iddistrito;
	}

	public void setIddistrito(Long iddistrito) {
		this.iddistrito = iddistrito;
	}

	public String getNomdistrito() {
		return nomdistrito;
	}

	public void setNomdistrito(String nomdistrito) {
		this.nomdistrito = nomdistrito;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	
	
	
	
	
	
}
