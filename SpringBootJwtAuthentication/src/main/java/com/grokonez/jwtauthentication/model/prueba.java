package com.grokonez.jwtauthentication.model;

import java.util.Date;

public class prueba {
	private String fecha;
	public prueba(String fecha, String nombre_act) {
		super();
		this.fecha = fecha;
		this.nombre_act = nombre_act;
	}
	private String nombre_act;


	
	
	public String getNombre_act() {
		return nombre_act;
	}
	public void setNombre_act(String nombre_ac) {
		this.nombre_act = nombre_ac;
	}
	
	public prueba() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
