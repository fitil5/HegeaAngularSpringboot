package com.grokonez.jwtauthentication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "actividad")
public class Actividad {
	@Id
	@Column(name="nombre_act")
	 private String nombre_act;

	public Actividad(String nombre_act) {
		super();
		this.nombre_act = nombre_act;
	}

	public Actividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre_act() {
		return nombre_act;
	}

	public void setNombre_act(String nombre_act) {
		this.nombre_act = nombre_act;
	}
}
