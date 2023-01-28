package com.hegea.jwtauthentication.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embeddable;


public class AltaActividad implements Serializable{
	/**
	 * 
	 */
	
	
	private Date fecha;
	private String nombre_act;
	private String usuario;
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
	

}
