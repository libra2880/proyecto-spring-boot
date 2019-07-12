package com.ventura.app.model;

import java.io.Serializable;
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
public class Producto implements Serializable{
  

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idproducto", updatable = false, nullable = false,unique=true)
	private Long idproducto;
	
	@Column(name="nomproducto",nullable=false,length=40)
	private String nomproducto;
	
	@Temporal(TemporalType.DATE)
	private Date fechaingreso;
	
	@Column(name="precio_venta",precision=10,scale=2,columnDefinition="Decimal(10,2)")
	private Double precioventa;
	
	@Column(name="precio_compra",precision=10,scale=2,columnDefinition="Decimal(10,2)")
	private Double preciocompra;
	
	
	@OneToMany(targetEntity=DetalleComprobante.class,mappedBy="producto",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<DetalleComprobante> detallecomprobante;


	public Long getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}


	public String getNomproducto() {
		return nomproducto;
	}


	public void setNomproducto(String nomproducto) {
		this.nomproducto = nomproducto;
	}


	public Date getFechaingreso() {
		return fechaingreso;
	}


	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}


	public Double getPrecioventa() {
		return precioventa;
	}


	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}


	public Double getPreciocompra() {
		return preciocompra;
	}


	public void setPreciocompra(Double preciocompra) {
		this.preciocompra = preciocompra;
	}


	public Set<DetalleComprobante> getDetallecomprobante() {
		return detallecomprobante;
	}


	public void setDetallecomprobante(Set<DetalleComprobante> detallecomprobante) {
		this.detallecomprobante = detallecomprobante;
	}
	
	
	
}
