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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Comprobante implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "idcomprobante", updatable = false, nullable = false,unique=true)
	private Long idcomprobante;
	
	@Column(name="numero",nullable=false,length=6)
	private String numero;
	
	@Column(name="serie",nullable=false,length=3)
	private String serie;
	
	@Column(name = "descipcion", nullable = false, length = 250)
	private String descripcion;
	
	@Column(name = "observacion", nullable = false, length = 250)
	private String observacion;

    @NotNull(message="No puede estar vacio")
    @Column(name="fecha_emision")
	@Temporal(TemporalType.DATE)
	private Date fechaemision;
    
    @PrePersist
    public void prePersist() {
    	this.fechaemision=new Date();
    }
	
    @NotNull(message="No puede estar vacio")
    @Column(name="fecha_vencimiento")
	@Temporal(TemporalType.DATE)
	private Date fechavencimiento;
	
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="idtipocomprobante")
	private TipoComprobante tipocomprobante;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idtipomoneda")
	private TipoMoneda tipomoneda;
	
	@ManyToOne
	@JoinColumn(name="idtipoventa")
	private TipoVenta tipoventa;
	
	@OneToMany(targetEntity=DetalleComprobante.class,mappedBy="comprobante"
	,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<DetalleComprobante> detallecomprobante;
	
	
	
}
