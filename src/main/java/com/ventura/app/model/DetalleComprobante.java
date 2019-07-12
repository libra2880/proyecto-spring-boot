package com.ventura.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleComprobante implements Serializable {

	
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "iddetallecomprobante", updatable = false, nullable = false,unique=true)
	private Long iddetallecomprobante;
	
	
	
	
	
	@Column(name="descuento",precision=10,scale=2,columnDefinition="Decimal(10,2)")
	private Double descuento;
	
	
	@Column(name="peso",precision=10,scale=2,columnDefinition="Decimal(10,2)")
	private Double peso;
	
	
	
	@ManyToOne
	@JoinColumn(name="idcomprobante")
	private Comprobante comprobante;
	
	@ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;

	public Long getIddetallecomprobante() {
		return iddetallecomprobante;
	}

	public void setIddetallecomprobante(Long iddetallecomprobante) {
		this.iddetallecomprobante = iddetallecomprobante;
	}

	
	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}



	

	

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Double calcularImporte() {
		return peso.doubleValue()*producto.getPrecioventa();
	}
	
	
}
