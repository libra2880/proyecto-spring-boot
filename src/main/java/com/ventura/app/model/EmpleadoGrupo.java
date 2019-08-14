package com.ventura.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmpleadoGrupo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idempleadogrupo", updatable = false, nullable = false,unique=true)
	private Long idempleadogrupo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idempleado")
	private Empleado empleado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idgrupo")
	private Grupo grupo;
	
	
	public Long getIdempleadogrupo() {
		return idempleadogrupo;
	}
	public void setIdempleadogrupo(Long idempleadogrupo) {
		this.idempleadogrupo = idempleadogrupo;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
}
