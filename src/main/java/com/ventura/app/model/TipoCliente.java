package com.ventura.app.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TipoCliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idtipocliente", updatable = false, nullable = false,unique=true)
	private Long idtipocliente;
	
	@Column(name="descripcion",nullable=false,length=40)
	private String descripcion;
	
	@OneToMany(targetEntity=Cliente.class,mappedBy="tipocliente",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Cliente> cliente;

	public Long getIdtipocliente() {
		return idtipocliente;
	}

	public void setIdtipocliente(Long idtipocliente) {
		this.idtipocliente = idtipocliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return String.format("TipoCliente [idtipocliente=%s, descripcion=%s, cliente=%s]", idtipocliente, descripcion,
				cliente);
	}
	
	
 	
	
}
