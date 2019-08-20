package com.ventura.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idempleado")
	private Empleado empleado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtipocomprobante")
	private TipoComprobante tipocomprobante;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtipomoneda")
	private TipoMoneda tipomoneda;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtipoventa")
	private TipoVenta tipoventa;
	
	@OneToMany(targetEntity=DetalleComprobante.class,mappedBy="comprobante"
	,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	
	private List<DetalleComprobante> detallecomprobante;
	
	
	

	public Comprobante() {
		this.detallecomprobante=new ArrayList<DetalleComprobante>();
	}

	public Long getIdcomprobante() {
		return idcomprobante;
	}

	public void setIdcomprobante(Long idcomprobante) {
		this.idcomprobante = idcomprobante;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaemision() {
		return fechaemision;
	}

	public void setFechaemision(Date fechaemision) {
		this.fechaemision = fechaemision;
	}

	public Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TipoComprobante getTipocomprobante() {
		return tipocomprobante;
	}

	public void setTipocomprobante(TipoComprobante tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoMoneda getTipomoneda() {
		return tipomoneda;
	}

	public void setTipomoneda(TipoMoneda tipomoneda) {
		this.tipomoneda = tipomoneda;
	}

	public TipoVenta getTipoventa() {
		return tipoventa;
	}

	public void setTipoventa(TipoVenta tipoventa) {
		this.tipoventa = tipoventa;
	}

	public List<DetalleComprobante> getDetallecomprobante() {
		return detallecomprobante;
	}

	public void setDetallecomprobante(List<DetalleComprobante> detallecomprobante) {
		this.detallecomprobante = detallecomprobante;
	}
	
	public Double getTotal() {
		Double total=0.0;
		int size=detallecomprobante.size();
		
		for(int i=0; i<size ; i++) {
			
			total+=detallecomprobante.get(i).calcularImporte();
		}
		return total;
	}
	
	
	
}
