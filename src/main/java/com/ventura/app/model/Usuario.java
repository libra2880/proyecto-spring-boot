package com.ventura.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Usuario extends AbstractPersistable<Long> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private  Long id;

	private String usuarioId;
	
	private String usuarioNombre;
	
	private String clave;
	
	@ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rol;
	
	
	@OneToMany(targetEntity=Direccion.class, mappedBy="usuario", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Direccion> direcciones;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	
	
	
	

}
