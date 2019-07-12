package com.ventura.app.model;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Factura implements Serializable{

	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo", updatable = false, nullable = false,unique=true)
	private Long codigo;
	
    @Column(name = "numfact", updatable = false, nullable = false,unique=true)
	private Long numfact;
    
    @Column(name = "serfact", updatable = false, nullable = false,unique=true)
	private Long serfact;
    
    @NotNull(message="No puede estar vacio")
    @Column(name="fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    
    private String descripcion;
    
    private String observacion;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Cliente cliente;
    
    @PrePersist
    public void prePersist() {
    	fechaRegistro=new Date();
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getNumfact() {
		return numfact;
	}

	public void setNumfact(Long numfact) {
		this.numfact = numfact;
	}

	public Long getSerfact() {
		return serfact;
	}

	public void setSerfact(Long serfact) {
		this.serfact = serfact;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	
}
