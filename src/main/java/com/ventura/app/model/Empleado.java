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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empleado implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idempleado", updatable = false, nullable = false,unique=true)
	private Long idempleado;
	
	@Column(name="nombre",nullable=false,length=40)
	private String nombre;
	
	@Column(name="appaterno",nullable=false,length=40)
	private String appaterno;
	
	@Column(name="apmaterno",nullable=false,length=40)
	private String apmaterno;
	
	@Column(name="direccion",nullable=false,length=40)
	private String direccion;
	
	@Column(name="tipovia",nullable=false,length=40)
	private String tipovia;
	
	@Column(name="numero",nullable=false,length=4)
	private String numero;
	
	@Column(name="interior",nullable=false,length=5)
	private String interior;
	
	@Column(name="nombrevia",nullable=false,length=40)
	private String nombrevia;
	
	@Column(name="tipozona",nullable=false,length=40)
	private String tipozona;
	
	@Column(name="email",nullable=false,length=40)
	private String email;
	
	@Column(name="nombrezona",nullable=false,length=40)
	private String nombrezona;
	
	@Column(name="referencia",nullable=false,length=400)
	private String referencia;
	
	@Temporal(TemporalType.DATE)
	private Date fechanac;
	
	@Column(name="celular",nullable=false,length=9)
	private String celular;
	
	@Column(name="ruc",nullable=false,length=11)
	private String ruc;
	
	@Column(name="usuario_nombre",nullable=false,length=40)
	private String usuarioNombre;
	
	@Column(name="clave",nullable=false,length=200)
	private String clave;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idtipoempleado")
	private TipoEmpleado tipoempleado;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idniveleducacion")
	private NivelEducacion niveleducacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idestadocivil")
	private EstadoCivil estadocivil;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idgenero")
	private Genero genero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tid")	
	private Tienda tienda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idtipodocu")	
	private TipoDocumento tipodocumento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idgradoins")	
	private GradoInstruccion gradoinstruccion;
	
	@OneToMany(targetEntity=EmpleadoGrupo.class,mappedBy="empleado",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<EmpleadoGrupo>empleadogrupo;
	
	@OneToMany(targetEntity=Comprobante.class,mappedBy="empleado",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Comprobante> comprobante;

	
	
	
	
	public Long getIdempleado() {
		return idempleado;
	}



	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTipovia() {
		return tipovia;
	}



	public void setTipovia(String tipovia) {
		this.tipovia = tipovia;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getInterior() {
		return interior;
	}



	public void setInterior(String interior) {
		this.interior = interior;
	}



	public String getNombrevia() {
		return nombrevia;
	}



	public void setNombrevia(String nombrevia) {
		this.nombrevia = nombrevia;
	}



	public String getTipozona() {
		return tipozona;
	}



	public void setTipozona(String tipozona) {
		this.tipozona = tipozona;
	}



	public String getNombrezona() {
		return nombrezona;
	}



	public void setNombrezona(String nombrezona) {
		this.nombrezona = nombrezona;
	}



	public String getReferencia() {
		return referencia;
	}



	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



	public Date getFechanac() {
		return fechanac;
	}



	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getRuc() {
		return ruc;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public TipoDocumento getTipodocumento() {
		return tipodocumento;
	}



	public void setTipodocumento(TipoDocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}



	public void setRuc(String ruc) {
		this.ruc = ruc;
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



	public TipoEmpleado getTipoempleado() {
		return tipoempleado;
	}



	public void setTipoempleado(TipoEmpleado tipoempleado) {
		this.tipoempleado = tipoempleado;
	}



	public NivelEducacion getNiveleducacion() {
		return niveleducacion;
	}



	public void setNiveleducacion(NivelEducacion niveleducacion) {
		this.niveleducacion = niveleducacion;
	}



	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}



	public void setEstadocivil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}



	public Tienda getTienda() {
		return tienda;
	}



	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}



	public Genero getGenero() {
		return genero;
	}



	public void setGenero(Genero genero) {
		this.genero = genero;
	}



	public Set<EmpleadoGrupo> getEmpleadogrupo() {
		return empleadogrupo;
	}



	public void setEmpleadogrupo(Set<EmpleadoGrupo> empleadogrupo) {
		this.empleadogrupo = empleadogrupo;
	}



	public Set<Comprobante> getComprobante() {
		return comprobante;
	}



	public void setComprobante(Set<Comprobante> comprobante) {
		this.comprobante = comprobante;
	}



	public GradoInstruccion getGradoinstruccion() {
		return gradoinstruccion;
	}



	public void setGradoinstruccion(GradoInstruccion gradoinstruccion) {
		this.gradoinstruccion = gradoinstruccion;
	}
	
	
	
	
}
