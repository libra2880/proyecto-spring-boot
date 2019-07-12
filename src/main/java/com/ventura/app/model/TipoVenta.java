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
public class TipoVenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idtipoventa", updatable = false, nullable = false,unique=true)
	private Long idtipoventa;
	
	@Column(name="descripcion",nullable=false,length=40)
	private String descripcion;
	
	
	@OneToMany(targetEntity=Comprobante.class,mappedBy="tipoventa",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Comprobante> comprobante;
	
}
