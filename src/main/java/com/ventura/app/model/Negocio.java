package com.ventura.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ventura.app.estado.Estado;

@Entity
public class Negocio {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "nid", updatable = false, nullable = false)
	 private Long nid;
	 
	 @Column(name = "nombre", nullable = false, length = 20)
	 private String nombre;
	 
	 
	 @Column(name="estado", nullable = false, length = 8 )
	 @Enumerated(value = EnumType.STRING)
	 private Estado estado;
	 
	 @OneToMany(targetEntity=Tienda.class,mappedBy="negocio", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 private Set<Tienda> tienda;




	public Long getNid() {
		return nid;
	}


	public void setNid(Long nid) {
		this.nid = nid;
	}


	public Set<Tienda> getTienda() {
		return tienda;
	}


	public void setTienda(Set<Tienda> tienda) {
		this.tienda = tienda;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	 
	 
	 
	 
}
