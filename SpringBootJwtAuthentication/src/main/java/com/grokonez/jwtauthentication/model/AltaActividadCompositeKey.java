package com.grokonez.jwtauthentication.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "alta_actividad")
@IdClass(AltaActividad.class)
public class AltaActividadCompositeKey implements Serializable{
	
	
	@Id
	@Column(name="fecha")
	private Date fecha;
	@Id
	@Column(name="nombre_act")
	private String nombre_act;
	@Id
	private String usuario;
	@Column(name="alta")
	private Boolean alta;
	public AltaActividadCompositeKey(Date fecha, String nombre_act, String usuario, Boolean alta, String name) {
		super();
		this.fecha = fecha;
		this.nombre_act = nombre_act;
		this.usuario = usuario;
		this.alta = alta;
		this.name = name;
	}
	@Column(name="name")
	private String name;
	public AltaActividadCompositeKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public AltaActividadCompositeKey(Date fecha, String nombre_act) {
		super();
		this.fecha = fecha;
		this.nombre_act = nombre_act;
	}

	public AltaActividadCompositeKey(String usuario, Boolean alta) {
		super();
		this.usuario = usuario;
		this.alta = alta;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNombre_act() {
		return nombre_act;
	}
	public void setNombre_act(String nombre_act) {
		this.nombre_act = nombre_act;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public Boolean getAlta() {
		return alta;
	}
	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

}
