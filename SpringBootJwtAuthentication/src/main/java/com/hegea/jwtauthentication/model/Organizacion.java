package com.hegea.jwtauthentication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizacion")
public class Organizacion {
	@Id
	@Column(name="nombre_org")
	private String nombre_org;

	public String getNombre_org() {
		return nombre_org;
	}

	public void setNombre_org(String nombre_org) {
		this.nombre_org = nombre_org;
	}

	public Organizacion(String nombre_org) {
		super();
		this.nombre_org = nombre_org;
	}

	public Organizacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
