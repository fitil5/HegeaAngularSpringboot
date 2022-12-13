package com.grokonez.jwtauthentication.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Embeddable;



public class FechaActividad implements Serializable{
	/**
	 * 
	 */
	
	
	
	
	private Date  fecha;
	private String nombre_act;


	
	public FechaActividad(Date fecha, String nombre_act) {
		super();
		this.fecha = fecha;
		this.nombre_act = nombre_act;
	}
	public String getNombre_act() {
		return nombre_act;
	}
	public void setNombre_act(String nombre_ac) {
		this.nombre_act = nombre_ac;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public FechaActividad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
