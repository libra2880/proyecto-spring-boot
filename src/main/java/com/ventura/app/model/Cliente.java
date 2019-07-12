package com.ventura.app.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cliente {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcliente", updatable = false, nullable = false,unique=true)
	private Long idcliente;
	
	@Column(name="nombre",length=40)
	private String nombre;
	
	
	@Column(name="appaterno",length=40)
	private String appaterno;
	
	@Column(name="apmaterno" ,length=40)
	private String apmaterno;
	
	@Column(name="dni",length=11)
	private String dni;
	
	@Column(name="ruc" ,length=11,unique=true)
	private String ruc;
	
	@Column(name="razonsocial" ,length=100)
	private String razonsocial;
	
	@Column(name="email",length=100)
	private String email;
	
	@Column(name="telefono",length=20)
	private String telefono;
	
	@Column(name="celular",length=20)
	private String celular;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fechanacimiento;
	
	
	
	@Temporal(TemporalType.DATE)
	private Date fecharegistro;
	
	@ManyToOne
	@JoinColumn(name="idtipocliente")
	private TipoCliente tipocliente;
	
	@OneToMany(targetEntity=Comprobante.class,mappedBy="cliente",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Comprobante> comprobante;
	

	
	
	public Cliente() {
		comprobante=new ArrayList<Comprobante>();
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAppaterno() {
		return appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}

	public String getApmaterno() {
		return apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public TipoCliente getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(TipoCliente tipocliente) {
		this.tipocliente = tipocliente;
	}

	

	
	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<Comprobante> getComprobante() {
		return comprobante;
	}

	public void setComprobante(List<Comprobante> comprobante) {
		this.comprobante = comprobante;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}


	
	
	
}
